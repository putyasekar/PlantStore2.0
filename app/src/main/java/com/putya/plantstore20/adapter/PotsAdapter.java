package com.putya.plantstore20.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.putya.plantstore20.R;
import com.putya.plantstore20.model.Pot;

import java.util.List;

public class PotsAdapter extends RecyclerView.Adapter<PotsAdapter.ViewHolder> {
    Context context;
    List<Pot> potList;

    public PotsAdapter(Context context, List<Pot> potList) {
        this.context = context;
        this.potList = potList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pot_row_items, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.potPrice.setText("IDR " + potList.get(position).getPrice());

        Glide.with(context).load(potList.get(position).getImageUrl()).into(holder.potImage);
    }

    @Override
    public int getItemCount() {
        return potList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView potImage;
        TextView potPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            potImage = itemView.findViewById(R.id.pots_image);
            potPrice = itemView.findViewById(R.id.pots_price);
        }
    }
}
