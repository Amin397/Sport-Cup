package com.example.sportcup.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportcup.R;
import com.example.sportcup.activities.item_detaile.Item_detiels;
import com.example.sportcup.models.Recycler_Items_Models;

import java.util.List;

public class Recycler_Items_Adapter extends RecyclerView.Adapter<Recycler_Items_Adapter.ViewHolder>{

    private Context context;
    private List<Recycler_Items_Models> models;

    public Recycler_Items_Adapter(Context context, List<Recycler_Items_Models> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recycler_items , viewGroup , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Recycler_Items_Models rm = models.get(i);

        viewHolder.image.setImageResource(rm.getImage());
        viewHolder.name.setText(rm.getName());
        viewHolder.location.setText(rm.getLocation());
        viewHolder.rate.setText(rm.getRate());
        viewHolder.cost.setText(rm.getCost());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , Item_detiels.class);
                intent.putExtra("name" , rm.getName());
                intent.putExtra("image" , rm.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

         CardView cardView;
         TextView name , location , cost , rate;
         ImageView image;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_items_id);
            name = (TextView) itemView.findViewById(R.id.txt_items_name_id);
            location = (TextView) itemView.findViewById(R.id.txt_items_location_id);
            cost = (TextView) itemView.findViewById(R.id.txt_items_cost_id);
            rate = (TextView) itemView.findViewById(R.id.txt_items_rate_score_id);
            image = (ImageView) itemView.findViewById(R.id.img_item_picture_id);

        }
    }
}
