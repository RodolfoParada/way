package com.rodolfo.tortados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.AsyncTask;
import android.os.Bundle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Torta> listaTorta;
    List<TortaDetalle> listaTortaDetalles;
    RecyclerView rvTortas;
    TortaAdapter tortaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // El programa sigue patrón MVC con el MainActivity.java como Controlador
        // Carga los cakes desde la API-REST
        listaTorta = new ArrayList<Torta>();
        listaTortaDetalles = new ArrayList<TortaDetalle>();
        rvTortas = (RecyclerView) findViewById(R.id.rvCakes);
        rvTortas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loadCakes();
    }

    private void loadCakes() {
        new LoadCakes().execute();
    }

    private class LoadCakes extends AsyncTask<String, Void, String> {
        // Lee la data desde el endpoint cakes y la deja en la variable global listCakes
        // Lee la data desde el endpoint details y la deja en la variable global listCakeDetails
        @Override
        protected String doInBackground(String... strings) {
            try{
                listaTorta = getRetrofit(0).create(TortaAPI.class).getTorta("cakes").execute().body();

                for(int i=0; i < listaTorta.size(); i++) {
                    TortaDetalle cakeDetails = getRetrofit(1).create(TortaAPI.class).getTortaDetalle(Integer.toString(listaTorta.get(i).getId())).execute().body();
                    listaTortaDetalles.add(cakeDetails);
                }
                loadCakesIntoDB();
            } catch(IOException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private void loadCakesIntoDB() {
            try {
                // Carga los cakes de listCakes a la tabla cake_entity
                for (int i = 0; i < listaTorta.size(); i++) {
                    TortaApp.basededatoApp.tortaDAO().addTorta(new TortaEntity(
                                    listaTorta.get(i).getId(),
                                    listaTorta.get(i).getTitle(),
                                    listaTorta.get(i).getPreviewDescription(),
                                    listaTorta.get(i).getSize(),
                                    listaTorta.get(i).getPrice(),
                                    listaTorta.get(i).getImage()
                            )
                    );
                }

                // Carga los cakes de listCakeDetails a la tabla cake_detail_entity
                for (int i = 0; i < listaTortaDetalles.size(); i++) {
                    TortaApp.basededatoApp.tortaDAO().addTortaDetalle(new TortaDetalleEntity(
                                    listaTortaDetalles.get(i).getId(),
                                    listaTortaDetalles.get(i).getTitle(),
                                    listaTortaDetalles.get(i).getPreviewDescription(),
                                    listaTortaDetalles.get(i).getDetailDescription(),
                                    listaTortaDetalles.get(i).getImage(),
                                    listaTortaDetalles.get(i).getShape(),
                                    listaTortaDetalles.get(i).getSize(),
                                    listaTortaDetalles.get(i).getPrice(),
                                    listaTortaDetalles.get(i).getLastPrice(),
                                    listaTortaDetalles.get(i).isDelivery()
                            )
                    );
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        // Carga la data desde las listas listCakes y listCakeDetails a la BD Room
        @Override
        protected void onPostExecute(String result) {
            // Carga los datos en el RV
            // cakeAdapter.refreshMyList(listCakes);
            // cakeAdapter.notifyDataSetChanged();

            tortaAdapter = new TortaAdapter(listaTorta, getApplicationContext());
            rvTortas.setAdapter(tortaAdapter);
        }

        private Retrofit getRetrofit(int mode) {
            // Si el modo es 0, retorna todo, sino retorna el detalle
            if (mode == 0) {
                return new Retrofit.Builder().baseUrl(getString(R.string.endPoint_Cakes)).addConverterFactory(GsonConverterFactory.create()).build();
            } else {
                return new Retrofit.Builder().baseUrl(getString(R.string.endPoint_CakeDetails)).addConverterFactory(GsonConverterFactory.create()).build();
            }
        }
    }

}