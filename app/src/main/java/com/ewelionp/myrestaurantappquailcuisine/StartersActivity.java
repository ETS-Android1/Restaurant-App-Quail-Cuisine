package com.ewelionp.myrestaurantappquailcuisine;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StartersActivity extends AppCompatActivity {

    private ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> sMeals;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);


        sMeals = new ArrayList<>();

        sMeals = (ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal>) getIntent().getSerializableExtra("Meals");

        mRecyclerView = findViewById(R.id.myList);
        setAdapter();


    }
    /**
     * Setting adapter
     */
    private void setAdapter() {
        com.ewelionp.myrestaurantappquailcuisine.MyRecyclerAdapter adapter = new com.ewelionp.myrestaurantappquailcuisine.MyRecyclerAdapter(sMeals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}