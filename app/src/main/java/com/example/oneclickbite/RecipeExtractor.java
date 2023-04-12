package com.example.oneclickbite;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class RecipeExtractor {
    String recipeTitle, recipeCuisine, recipeTime;
    String responseData;
    private ArrayList<String> ingrs;
    private ArrayList<String> recipe;

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeCuisine() {
        return recipeCuisine;
    }

    public String getRecipeTime() {
        return recipeTime;
    }

    public ArrayList<String> getIngrs() {
        return ingrs;
    }

    public ArrayList<String> getRecipe() {
        return recipe;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    RecipeExtractor(){
        this.ingrs = new ArrayList<>();
        this.recipe = new ArrayList<>();
    }

    // for https://www.addapinch.com/
    public void scrapeData1() throws IOException {

        Document doc = Jsoup.parse(responseData);
        Elements title = doc.getElementsByClass("entry-title");
//        System.out.println(Objects.requireNonNull(title.first()).text().toUpperCase());
        recipeTitle = Objects.requireNonNull(title.first()).text().toUpperCase();

        Elements cuisine_detail = doc.getElementsByClass("wprm-recipe-cuisine");
//        System.out.println("Cuisine: "+cuisine_detail.get(0).text());
        recipeCuisine = cuisine_detail.get(0).text();

        Elements prep_time_hour = doc.getElementsByClass("wprm-recipe-prep_time-hours");
        Elements prep_time_mins = doc.getElementsByClass("wprm-recipe-prep_time-minutes");

        Elements cook_time_hour = doc.getElementsByClass("wprm-recipe-cook_time-hours");
        Elements cook_time_mins = doc.getElementsByClass("wprm-recipe-cook_time-minutes");

        int p_hour, p_min, c_hour, c_min;

        if(prep_time_hour.isEmpty())    p_hour = 0;
        else    p_hour = Integer.parseInt(Objects.requireNonNull(prep_time_hour.first()).text());

        if(prep_time_mins.isEmpty())    p_min = 0;
        else    p_min = Integer.parseInt(Objects.requireNonNull(prep_time_mins.first()).text());

        if(cook_time_hour.isEmpty())    c_hour = 0;
        else    c_hour = Integer.parseInt(Objects.requireNonNull(cook_time_hour.first()).text());

        if(cook_time_mins.isEmpty())    c_min = 0;
        else    c_min = Integer.parseInt(Objects.requireNonNull(cook_time_mins.first()).text());

        int total_recipe_time_mins = (p_hour + c_hour) * 60 + (p_min + c_min);

        int recipe_hour = total_recipe_time_mins / 60;
        int recipe_mins = total_recipe_time_mins % 60;

        // setting up recipe time
        String recipe_time;
        if(recipe_hour == 0){
            recipe_time = recipe_mins + " mins";
        } else if (recipe_hour == 1) {
            recipe_time = recipe_hour + " hour " + recipe_mins + " mins";
        } else{
            recipe_time = recipe_hour + " hours " + recipe_mins + " mins";
        }

//        System.out.println("Recipe time : " +recipe_time);
        recipeTime = recipe_time;

//        System.out.println("----------------------------");
        // INGREDIENTS EXTRACTION

        Elements ingredients = doc.getElementsByClass("wprm-recipe-ingredient");

        for(Element i: ingredients){
            String amount = i.getElementsByClass("wprm-recipe-ingredient-amount").text();
            String unit = i.getElementsByClass("wprm-recipe-ingredient-unit").text();
            String name = i.getElementsByClass("wprm-recipe-ingredient-name").text();
            String notes = i.getElementsByClass("wprm-recipe-ingredient-notes").text();

            String ing = amount+" "+unit+" "+name+" "+notes;
            ing = ing.strip();
            ingrs.add(ing);
        }

        // STEPS EXTRACTION

        Elements steps = doc.getElementsByClass("wprm-recipe-instruction");

        for (Element step:steps){
            recipe.add(step.text().strip());
        }

    }

    // for https://www.lifeloveandsugar.com/
    public void scrapeData2() throws IOException {

        Document doc = Jsoup.parse(responseData);

        Elements title = doc.getElementsByClass("tasty-recipes-title");
//        System.out.println(Objects.requireNonNull(title.first()).text().toUpperCase());
//        System.out.println("----------------------------");
        recipeTitle = Objects.requireNonNull(title.first()).text().toUpperCase();

        Elements cuisine_detail = doc.getElementsByClass("tasty-recipes-cuisine");
//        System.out.println("Cuisine: "+cuisine_detail.get(0).text());
        recipeCuisine = cuisine_detail.get(0).text();

        Elements recipe_time = doc.getElementsByClass("tasty-recipes-total-time");
//        System.out.println("Recipe Time: "+recipe_time.get(0).text());
        recipeTime = String.valueOf(recipe_time);

        Elements ingredients = doc.getElementsByClass("tasty-recipes-ingredients-body");
        Elements ingr_li = Objects.requireNonNull(ingredients.first()).getElementsByTag("li");

        for (Element e: ingr_li
        ) {
//            System.out.println(e.text());
            ingrs.add(e.text());
        }

        Elements steps = doc.getElementsByClass("tasty-recipes-instructions-body");
//        System.out.println(steps.text());
        Elements steps_li = Objects.requireNonNull(steps.first()).getElementsByTag("li");

        for (Element e: steps_li
        ) {
//            System.out.println(e.text());
            recipe.add(e.text());
        }


    }

    // for https://natashaskitchen.com/
    public void scrapeData3() throws IOException {

        Document doc = Jsoup.parse(responseData);
        Elements title = doc.getElementsByClass("wprm-recipe-name");
//        System.out.println(Objects.requireNonNull(title.first()).text().toUpperCase());
//        System.out.println("----------------------------");
        recipeTitle = Objects.requireNonNull(title.first()).text().toUpperCase();

        Elements cuisine_detail = doc.getElementsByClass("wprm-recipe-cuisine");
//        System.out.println("Cuisine: "+cuisine_detail.get(0).text());
        recipeCuisine = cuisine_detail.get(0).text();

        Elements prep_time_hour = doc.getElementsByClass("wprm-recipe-prep_time-hours");
        Elements prep_time_mins = doc.getElementsByClass("wprm-recipe-prep_time-minutes");

        Elements cook_time_hour = doc.getElementsByClass("wprm-recipe-cook_time-hours");
        Elements cook_time_mins = doc.getElementsByClass("wprm-recipe-cook_time-minutes");

        int p_hour, p_min, c_hour, c_min;

        if(prep_time_hour.isEmpty())    p_hour = 0;
        else    p_hour = Integer.parseInt(Objects.requireNonNull(prep_time_hour.first()).text());

        if(prep_time_mins.isEmpty())    p_min = 0;
        else    p_min = Integer.parseInt(Objects.requireNonNull(prep_time_mins.first()).text());

        if(cook_time_hour.isEmpty())    c_hour = 0;
        else    c_hour = Integer.parseInt(Objects.requireNonNull(cook_time_hour.first()).text());

        if(cook_time_mins.isEmpty())    c_min = 0;
        else    c_min = Integer.parseInt(Objects.requireNonNull(cook_time_mins.first()).text());

        int total_recipe_time_mins = (p_hour + c_hour) * 60 + (p_min + c_min);

        int recipe_hour = total_recipe_time_mins / 60;
        int recipe_mins = total_recipe_time_mins % 60;

        // setting up recipe time
        String recipe_time;
        if(recipe_hour == 0){
            recipe_time = recipe_mins + " mins";
        } else if (recipe_hour == 1) {
            recipe_time = recipe_hour + " hour " + recipe_mins + " mins";
        } else{
            recipe_time = recipe_hour + " hours " + recipe_mins + " mins";
        }

//        System.out.println("Recipe time : " +recipe_time);
        recipeTime = recipe_time;

//        System.out.println("----------------------------");
        // INGREDIENTS EXTRACTION

        Elements ingredients = doc.getElementsByClass("wprm-recipe-ingredient");

        for(Element i: ingredients){
            String amount = i.getElementsByClass("wprm-recipe-ingredient-amount").text();
            String unit = i.getElementsByClass("wprm-recipe-ingredient-unit").text();
            String name = i.getElementsByClass("wprm-recipe-ingredient-name").text();
            String notes = i.getElementsByClass("wprm-recipe-ingredient-notes").text();

            String ing = amount+" "+unit+" "+name+" "+notes;
            ing = ing.strip();
            ingrs.add(ing);
        }

        // STEPS EXTRACTION

        Elements steps = doc.getElementsByClass("wprm-recipe-instruction");

        for (Element step:steps){
            recipe.add(step.text().strip());
        }

    }

    // for https://www.eitanbernath.com/
    public void scrapeData4() throws IOException {
        Document doc = Jsoup.parse(responseData);
        Elements title = doc.getElementsByClass("zrdn-element_recipe_title");
//        System.out.println(Objects.requireNonNull(title.first()).text().toUpperCase());
//        System.out.println("----------------------------");
        recipeTitle = Objects.requireNonNull(title.first()).text().toUpperCase();

        String cuisine = "";
//        System.out.println("Cuisine: "+cuisine);
        recipeCuisine = cuisine;

        String recipe_time = "";
        Elements total_time = doc.getElementsByClass("zrdn-element_total_time");
        if(!total_time.isEmpty()) {
            recipe_time = Objects.requireNonNull(total_time.first()).text();
            recipe_time = recipe_time.replace(",","");
        }

//        System.out.println("Recipe Time: "+recipe_time);
        recipeTime = recipe_time;

        // INGREDIENTS EXTRACTION

        Elements ingr_class = doc.getElementsByClass("zrdn-ingredients-list");

        for (Element e: ingr_class
        ) {
            Elements ing_list = e.getElementsByTag("li");
            for (Element i: ing_list
            ) {
                ingrs.add(i.text());
            }
        }

        // STEPS EXTRACTION

        Elements steps = doc.getElementsByClass("zrdn-instructions");
        Elements steps_li = Objects.requireNonNull(steps.first()).getElementsByTag("li");

        for (Element e: steps_li
        ) {
            recipe.add(e.text());
        }


    }

    // for https://www.thespruceeats.com/
    public void scrapeData5() throws IOException {
        Document doc = Jsoup.parse(responseData);
        Elements title = doc.getElementsByClass("heading__title");
//        System.out.println(Objects.requireNonNull(title.first()).text().toUpperCase());
//        System.out.println("----------------------------");
        recipeTitle = Objects.requireNonNull(title.first()).text().toUpperCase();

        String cuisine = "";
//        System.out.println("Cuisine: "+cuisine);
        recipeCuisine = cuisine;

        String recipe_time = "";
        Elements total_time = doc.getElementsByClass("total-time");
        if(!total_time.isEmpty()) {
            recipe_time = Objects.requireNonNull(total_time.first()).getElementsByClass("meta-text__data").text();
        }
//        System.out.println("Recipe Time: "+recipe_time);
        recipeTime = recipe_time;

        // INGREDIENTS EXTRACTION
        Elements ingredients = doc.getElementsByClass("structured-ingredients__list-item");

        for (Element e : ingredients
        ) {
            ingrs.add(e.text());
        }

        // STEPS EXTRACTION

        Elements steps = doc.getElementsByClass("structured-project__steps");
//        System.out.println(steps);

        Elements steps_li = Objects.requireNonNull(steps.first()).getElementsByTag("li");

        for (Element e: steps_li
        ) {
            recipe.add(e.text());
        }


    }

    // for http://allrecipes.com/
    public void scrapeData6() throws IOException {
        Document doc = Jsoup.parse(responseData);
        Element title = doc.getElementById("article-heading_1-0");
//        System.out.println(Objects.requireNonNull(title).text().toUpperCase());
//        System.out.println("----------------------------");
        recipeTitle = Objects.requireNonNull(title).text().toUpperCase();

        String cuisine = "";
//        System.out.println("Cuisine: "+cuisine);
        recipeCuisine = cuisine;

        Elements total_time = doc.getElementsByClass("mntl-recipe-details__value");
        String recipe_time = total_time.get(2).text();
//        System.out.println("Recipe Time: "+recipe_time);
        recipeTime = recipe_time;

        // INGREDIENTS EXTRACTION
        Elements ingredients = doc.getElementsByClass("mntl-structured-ingredients__list");
        Elements ingr_li = Objects.requireNonNull(ingredients.first()).getElementsByTag("li");

        for (Element e : ingr_li
        ) {
            ingrs.add(e.text());
        }

        // STEPS EXTRACTION

        Elements steps = doc.getElementsByClass("recipe__steps");
        Elements steps_li = Objects.requireNonNull(steps.first()).getElementsByTag("li");

        for (Element e: steps_li
        ) {
            recipe.add(e.text());
        }


    }

    // for https://www.delish.com/
    public void scrapeData7() throws IOException {
        Document doc = Jsoup.parse(responseData);
        Elements title = doc.getElementsByClass("exadjwu8");
//        System.out.println(Objects.requireNonNull(title.first()).text().toUpperCase());
//        System.out.println("----------------------------");
        recipeTitle = Objects.requireNonNull(title.first()).text().toUpperCase();

        String cuisine = "";
//        System.out.println("Cuisine: "+cuisine);
        recipeCuisine = cuisine;

        Elements total_time = doc.getElementsByClass("css-8govpn");
        String recipe_time = "";
        if(total_time.size() >= 2) {
            recipe_time = Objects.requireNonNull(total_time.get(2)).text();
        }
//        System.out.println("Recipe Time: "+recipe_time);
        recipeTime = recipe_time;

        // INGREDIENTS EXTRACTION
        Elements ingredients = doc.getElementsByClass("ingredient-lists");
        Elements ingr_li = Objects.requireNonNull(ingredients.first()).getElementsByTag("li");

        for (Element e : ingr_li
        ) {
            ingrs.add(e.text());
        }

        // STEPS EXTRACTION

        Elements steps = doc.getElementsByClass("css-1rk79nl");

        for (Element steps_item: steps
        ) {

            Elements steps_li = steps_item.getElementsByTag("li");

            for (Element e : steps_li
            ) {
                Elements span_ele = e.getElementsByTag("span");
                span_ele.remove();

                recipe.add(e.text());
            }

        }

    }

    // for https://pinchofyum.com/
    public void scrapeData8() throws IOException {
        Document doc = Jsoup.parse(responseData);
        Elements title = doc.getElementsByClass("tasty-recipes-title");
//        System.out.println(Objects.requireNonNull(title.first()).text().toUpperCase());
//        System.out.println("----------------------------");
        recipeTitle = Objects.requireNonNull(title.first()).text().toUpperCase();


        String cuisine = "";
//        System.out.println("Cuisine: "+cuisine);
        recipeCuisine = cuisine;

        Elements total_time = doc.getElementsByClass("tasty-recipes-total-time");
        String recipe_time = Objects.requireNonNull(total_time.first()).text();
//        System.out.println("Recipe Time: "+recipe_time);
        recipeTime = recipe_time;

        // INGREDIENTS EXTRACTION
        Elements ingredients = doc.getElementsByClass("tasty-recipes-ingredients");
        Elements ingr_li = Objects.requireNonNull(ingredients.first()).getElementsByTag("li");

        for (Element e : ingr_li
        ) {
            ingrs.add(e.text());
        }

        // STEPS EXTRACTION

        Elements steps = doc.getElementsByClass("tasty-recipes-instructions");

        Elements steps_li = Objects.requireNonNull(steps.first()).getElementsByTag("li");
        for (Element e : steps_li
        ) {
            Elements span_ele = e.getElementsByTag("span");
            span_ele.remove();

            recipe.add(e.text());
        }
    }

}
