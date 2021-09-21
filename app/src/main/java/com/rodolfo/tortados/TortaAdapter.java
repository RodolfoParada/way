package com.rodolfo.tortados;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class TortaAdapter extends RecyclerView.Adapter<TortaAdapter.ViewHolder>{
    List<Torta> tortaLista;
    Context context;

    public TortaAdapter(List<Torta> TortaLista, Context context) {
        this.tortaLista = TortaLista;
        this.context = context;
    }

    @NonNull
    @Override
    public TortaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.torta_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Torta torta = tortaLista.get(position);
        try {
            Picasso.get().load(tortaLista.get(position).getImage()).into(holder.ivCake);
            holder.tvTitle.setText(tortaLista.get(position).getTitle());
            holder.tvPrice.setText(Integer.toString(tortaLista.get(position).getPrice()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context,TortaDetalleActivity.class)
                            .putExtra("id",tortaLista.get(position).getId())
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    );
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return tortaLista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivCake;
        public TextView tvTitle;
        public TextView tvPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            this.ivCake = (ImageView) itemView.findViewById(R.id.ivCake);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        }
    }

}