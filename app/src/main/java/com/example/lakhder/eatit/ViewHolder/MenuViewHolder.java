package com.example.lakhder.eatit.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lakhder.eatit.Interface.ItemClickListener;
import com.example.lakhder.eatit.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtMenuName;
    public ImageView imageView;
    private ItemClickListener itemClickListener;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        txtMenuName = (TextView) itemView.findViewById(R.id.txtNameFood);
        imageView = itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);


    }



    //Getteur and Setteur


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
