package com.ewelionp.myrestaurantappquailcuisine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {


    private ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> meals;

    public MyRecyclerAdapter(ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> meals) {
        this.meals = meals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_meal, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String name = meals.get(position).getName();
        String description = meals.get(position).getDescription();
        float price = meals.get(position).getPrice();

        String nPrice = fmt(price);


        holder.name.setText(name);
        holder.description.setText(description);
        holder.price.setText("£" + nPrice);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView name;
        private TextView description;
        private TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.meal_name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);

        }

    }

    public static String fmt(float d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

}
