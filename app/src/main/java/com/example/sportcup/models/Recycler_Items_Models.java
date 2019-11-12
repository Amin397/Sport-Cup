package com.example.sportcup.models;


public class Recycler_Items_Models {

    private int image;
    private String name , cost , location , rate;

    public Recycler_Items_Models(String name, String cost, String location, String rate , int image) {
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.location = location;
        this.rate = rate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
