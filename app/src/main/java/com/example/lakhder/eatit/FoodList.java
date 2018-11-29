package com.example.lakhder.eatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lakhder.eatit.Interface.ItemClickListener;
import com.example.lakhder.eatit.ViewHolder.FoodMenuHolder;
import com.example.lakhder.eatit.ViewHolder.MenuViewHolder;
import com.example.lakhder.eatit.model.Category;
import com.example.lakhder.eatit.model.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {

    //Declaration Attributs
    FirebaseDatabase database;
    DatabaseReference food;

    //Recycle Attributs
    RecyclerView recycler_food;
    RecyclerView.LayoutManager layoutManager;

    //Adaptateur
    FirebaseRecyclerAdapter<Food, FoodMenuHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //Init the Firebase
        database = FirebaseDatabase.getInstance();
        food = database.getReference("Food");

        //the recycleView

        recycler_food = findViewById(R.id.recycler_food);
        recycler_food.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_food.setLayoutManager(layoutManager);

        if(getIntent() !=null){
            String categoryId = getIntent().getStringExtra("CategoryId");
            if(! categoryId.isEmpty() && categoryId != null){

                loadFood(categoryId);

            }
        }
    }



    private void loadFood(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Food, FoodMenuHolder>(Food.class,
                R.layout.food_item,
                FoodMenuHolder.class,
                //in this place we put what we need to return in this case we reutrn all the category records
                //like:select * from Category;
                food.orderByChild("MenuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(FoodMenuHolder viewHolder, Food model, int position) {
                viewHolder.txtFood.setText(model.getName());
                Picasso.get().load(model.getImage()).into(viewHolder.foodImage);
                final Food clickItem = model;

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(FoodList.this, "You Chose" + clickItem.getName(), Toast.LENGTH_LONG).show();

                    }
                });


            }
        };

        recycler_food.setAdapter(adapter);


}


}
