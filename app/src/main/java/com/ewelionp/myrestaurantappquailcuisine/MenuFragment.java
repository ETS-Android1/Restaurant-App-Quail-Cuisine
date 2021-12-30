package com.ewelionp.myrestaurantappquailcuisine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    CardView startersCard;
    CardView mainCoursesCard;
    CardView dessertsCard;

    private ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> mMeals;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        startersCard = view.findViewById(R.id.card_view_starters);
        mainCoursesCard = view.findViewById(R.id.card_view_main_courses);
        dessertsCard = view.findViewById(R.id.card_view_desserts);

        mMeals = new ArrayList<>();
        addMeals(mMeals);

        cardsListeners();

        return view;
    }

    /**
     * Adding cards listeners
     */
    private void cardsListeners() {
        startersCard.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), StartersActivity.class);
            Bundle mBundle = new Bundle();
            ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> sMeals = new ArrayList<>();
            for (int i = 0; i < mMeals.size(); i++) {
                if (mMeals.get(i).getCategory().equals("starter")) {
                    sMeals.add(mMeals.get(i));
                }
            }
            mBundle.putSerializable("Meals", sMeals);
            intent.putExtras(mBundle);

            startActivity(intent);
        });

        mainCoursesCard.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), MainCoursesActivity.class);
            Bundle mBundle = new Bundle();
            ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> sMeals = new ArrayList<>();
            for (int i = 0; i < mMeals.size(); i++) {
                if (mMeals.get(i).getCategory().equals("main")) {
                    sMeals.add(mMeals.get(i));
                }
            }
            mBundle.putSerializable("Meals", sMeals);
            intent.putExtras(mBundle);

            startActivity(intent);
        });

        dessertsCard.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), com.ewelionp.myrestaurantappquailcuisine.DessertsActivity.class);
            Bundle mBundle = new Bundle();
            ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> sMeals = new ArrayList<>();
            for (int i = 0; i < mMeals.size(); i++) {
                if (mMeals.get(i).getCategory().equals("dessert")) {
                    sMeals.add(mMeals.get(i));
                }
            }
            mBundle.putSerializable("Meals", sMeals);
            intent.putExtras(mBundle);

            startActivity(intent);
        });
    }

    /**
     * Initial meals list
     * @param meals meals
     */
    private void addMeals(ArrayList<com.ewelionp.myrestaurantappquailcuisine.Meal> meals) {

        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Black pepper and mustard seed soup", "Crushed black pepper and yellow mustard seeds combined into chunky soup", 17));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Cucumber and vermicelli soup", "Fresh cucumber and vermicelli combined into smooth soup", 18));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("dessert", "Date and popcorn cake", "Moist cake made with moist date and popcorn", 8.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Cabbage and cheese gyoza", "Thin pastry cases stuffed with chinese cabbage and creamy cheese", 11.25F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Sausage and rosemary parcels", "Thin filo pastry cases stuffed with spicy sausage and fresh rosemary", 12));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Camembert and strawberry pancake", "Fluffy pancake filled with camembert and fresh strawberries", 16.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Kohlrabi and prawn soup", "Kohlrabi and tiger prawns combined into smooth soup", 12.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Parsnip and haddock soup", "Fresh parsnips and smoked haddock combined into chunky soup", 12));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Leek and apple dumplings", "Thin pastry cases stuffed with fresh leek and cox apple", 11.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("starter", "Cucumber and pepper maki", "Toasted seaweed wrapped around sushi rice, filled with fresh cucumber and baby pepper", 11));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("dessert", "Cocoa and strawberry crumble", "Cocoa and fresh strawberries topped with crunchy crumble", 9));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("dessert", "Caramel and cardamom cheesecake", "A rich cheesecake layered with caramel and black cardamom", 9.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Aubergine and borlotti bean stir fry", "Crunchy stir fry featuring marinaded aubergine and fresh borlotti bean", 20.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Tuna and dolcelatte spaghetti", "Spagetti topped with a blend of tuna and dolcelatte", 21));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Limpa and bread", "Fluffy bread made with limpa and", 19.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Pancetta tart with garlic sauce", "A rich pastry case filled with pancetta and served with garlic sauce", 20));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Lavender and thyme stir fry", "Crunchy stir fry featuring fresh lavender and thyme", 22));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Bacon and black pepper soup", "Streaky bacon and crushed black pepper combined into smooth soup", 21.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Camembert and bulgur wheat salad", "A crisp salad featuring camembert and bulgur wheat", 20.75F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Bean and chicken korma", "Creamy korma made with bean and free range chicken", 23.25F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Beef Malayan", "Tender fillet tips simmered in curry cream sauce, green asparagus, hokkien noodles", 27));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Black Bean Pork", "Stir fried pork in fermented black bean sauce with ho fun noodles", 26.5F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Chicken Adobo", "Chicken breast with classic Filipino marinade of garlic, soy, chilli, vinegar and bay leaf served with steamed basmati rice", 25.75F));
        meals.add(new com.ewelionp.myrestaurantappquailcuisine.Meal("main", "Lamb Hanging Skewer", "Seven seas spiced lamb with pearl couscous, pomegranate & herb salad and mango chutney", 26.5F));
    }
}
