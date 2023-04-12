package com.example.oneclickbite;

public class FoodClass {

    private String foodTitle;
    private int foodImage;

    public FoodClass(String foodTitle, int foodImage) {
        this.foodTitle = foodTitle;
        this.foodImage = foodImage;
    }

    public FoodClass(){

    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }
}
