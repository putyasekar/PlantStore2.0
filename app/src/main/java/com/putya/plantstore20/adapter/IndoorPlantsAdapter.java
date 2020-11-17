package com.putya.plantstore20.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.putya.plantstore20.R;
import com.putya.plantstore20.activity.PlantDetailsActivity;
import com.putya.plantstore20.model.Recommended;

import java.util.List;

public class IndoorPlantsAdapter extends RecyclerView.Adapter<IndoorPlantsAdapter.ViewHolder> {

    public IndoorPlantsAdapter(Context context, List<Recommended> recommendedList) {
        this.context = context;
        this.recommendedList = recommendedList;
    }

    Context context;
    List<Recommended> recommendedList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.indoor_row_items, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.plantName.setText(recommendedList.get(position).getName());
        holder.plantPrice.setText("IDR " + recommendedList.get(position).getPrice());

        // for image it need to add dependency for fetching image from network

        Glide.with(context).load(recommendedList.get(position).getImageUrl()).into(holder.plantImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, PlantDetailsActivity.class);

                Pair[] pairs = new Pair[2];

                pairs[0] = new Pair<View, String>(holder.plantImage, "image");
                pairs[1] = new Pair<View, String>(holder.plantPrice, "price");

                i.putExtra("name", recommendedList.get(position).getName());
                i.putExtra("cat", recommendedList.get(position).getCategory());
                i.putExtra("size", recommendedList.get(position).getSize());
                i.putExtra("price", recommendedList.get(position).getPrice());
                i.putExtra("type", recommendedList.get(position).getType());
                i.putExtra("placement", recommendedList.get(position).getPlacement());
                i.putExtra("pot", recommendedList.get(position).getPot());
                i.putExtra("layer", recommendedList.get(position).getLayer());
                i.putExtra("height", recommendedList.get(position).getHeight());
                i.putExtra("dim", recommendedList.get(position).getDimention());
                i.putExtra("imgurl", recommendedList.get(position).getImageUrl());
                i.putExtra("desc", recommendedList.get(position).getDesc());


                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);

                context.startActivity(i, activityOptions.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return recommendedList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView plantImage;
        TextView plantName, plantPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plantImage = itemView.findViewById(R.id.plant_image);
            plantName = itemView.findViewById(R.id.plant_name);
            plantPrice = itemView.findViewById(R.id.plant_price);
        }
    }
}
