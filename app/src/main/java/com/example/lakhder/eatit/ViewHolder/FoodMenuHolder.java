package com.example.lakhder.eatit.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lakhder.eatit.Interface.ItemClickListener;
import com.example.lakhder.eatit.R;

public class FoodMenuHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {


    public ImageView foodImage;
    public TextView txtFood;
    private ItemClickListener itemClickListener;

    public FoodMenuHolder(@NonNull View itemView) {
        super(itemView);
        foodImage = itemView.findViewById(R.id.food_image);
        txtFood = itemView.findViewById(R.id.txtFood);
        itemView.setOnClickListener(this);

    }

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);


    }
}
