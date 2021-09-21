package com.rodolfo.tortados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class TortaDetalleActivity  extends AppCompatActivity {
    int tortaId;
    TextView tvTortaTitleDetail;
    TextView tvTortaPriceDetail;
    TextView tvTortaDescriptionDetail;
    ImageView ivTortaImageDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torta_detalle);
        tortaId = getIntent().getIntExtra("id",-1);
        tvTortaTitleDetail = (TextView) findViewById(R.id.tvCakeTitleDetail);
        tvTortaPriceDetail = (TextView) findViewById(R.id.tvCakePriceDetail);
        tvTortaDescriptionDetail = (TextView) findViewById(R.id.tvCakeDescriptionDetail);
        ivTortaImageDetail = (ImageView) findViewById(R.id.ivCakeImageDetail);
        new LoadCakeDetails().execute();
    }

    private class LoadCakeDetails extends AsyncTask<String, Void, String> {
        TortaDetalleEntity cakeDetailEntity;

        @Override
        protected String doInBackground(String... strings) {
            cakeDetailEntity = TortaApp.basededatoApp.tortaDAO().getTortaDetalleById(tortaId);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Picasso.get().load(cakeDetailEntity.getImage()).into(ivTortaImageDetail);
            tvTortaTitleDetail.setText(cakeDetailEntity.getTitle());
            tvTortaPriceDetail.setText(Integer.toString(cakeDetailEntity.getPrice()));
            tvTortaDescriptionDetail.setText(cakeDetailEntity.getDetailDescription());
        }
    }
}
