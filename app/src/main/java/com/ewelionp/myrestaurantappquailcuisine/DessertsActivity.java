package com.ewelionp.myrestaurantappquailcuisine;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DessertsActivity extends AppCompatActivity {

    private ArrayList<Meal> sMeals;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);


        sMeals = new ArrayList<>();

        sMeals = (ArrayList<Meal>) getIntent().getSerializableExtra("Meals");

        mRecyclerView = findViewById(R.id.myList);
        setAdapter();


    }

    private void setAdapter() {
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(sMeals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}