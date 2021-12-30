package com.ewelionp.myrestaurantappquailcuisine;

import java.io.Serializable;

public class Meal implements Serializable {

    private String category;
    private String name;
    private String description;
    private float price;

    public Meal(String category, String name, String description, float price) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
