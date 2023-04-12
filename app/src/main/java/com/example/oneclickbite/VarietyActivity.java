package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VarietyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FoodClass> foodClassList;
    String food="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety);

        recyclerView = findViewById(R.id.rv);
        foodClassList = new ArrayList<>();
        savedInstanceState = getIntent().getExtras();
        if(savedInstanceState!=null){

            food = savedInstanceState.getString("food");
            if(food!=null) {
                Log.i("food", food);
            }else{
                Log.i("food","NULL");
            }

        }


        GridLayoutManager gridLayoutManager = new GridLayoutManager(VarietyActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        if(food.equalsIgnoreCase("garlic bread")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Garlic Bread", R.drawable.garlic);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("french fries")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("French Fries", R.drawable.french_fries);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("cake")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            // Red Velvet Cake
            FoodClass food1 = new FoodClass("Red Velvet Cake", R.drawable.red_velvet);


            // Chocolate Cake
            FoodClass food2 = new FoodClass("Chocolate Cake", R.drawable.chocolate_cake);

            // Carrot Cake
            FoodClass food3 = new FoodClass("Carrot Cake", R.drawable.carrot_cake);

            // Strawberry Cake
            FoodClass food4 = new FoodClass("Strawberry Shortcake", R.drawable.strawberry_cake);


            // Cheese Cake
            FoodClass food5 = new FoodClass("Cheesecake", R.drawable.cheese_cake);

            foodClassList.add(food1);
            foodClassList.add(food2);
            foodClassList.add(food3);
            foodClassList.add(food4);
            foodClassList.add(food5);

        }else if(food.equalsIgnoreCase("pasta")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            // veg spaghetti
            FoodClass food1 = new FoodClass("Veg Spaghetti", R.drawable.veg_spaghetti);

            // non-veg spaghetti
            FoodClass food2 = new FoodClass("Non-Veg Spaghetti", R.drawable.nonveg_spaghetti);

            // lasagna
            FoodClass food3 = new FoodClass("Lasagna", R.drawable.lasagna);

            // mac and cheese
            FoodClass food4 = new FoodClass("Mac and Cheese", R.drawable.macaroni);



            foodClassList.add(food1);
            foodClassList.add(food2);
            foodClassList.add(food3);
            foodClassList.add(food4);



        }else if(food.equalsIgnoreCase("churros")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Churros", R.drawable.churros);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("tacos")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Tacos", R.drawable.taco);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("spring rolls")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Spring Rolls", R.drawable.spring_rolls);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("chicken wings")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Chicken Wings", R.drawable.chicken_wings);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("chicken curry")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Chicken Curry", R.drawable.chicken_curry);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("bruschetta")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Bruschetta", R.drawable.bruschetta);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("salad")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            // Greek Salad
            FoodClass food1 = new FoodClass("Greek Salad", R.drawable.greek_salad);

            // Caprese Salad
            FoodClass food2 = new FoodClass("Caprese Salad", R.drawable.caprese_salad);

            // Caesar Salad
            FoodClass food3 = new FoodClass("Caesar Salad", R.drawable.caesar_salad);


            foodClassList.add(food1);
            foodClassList.add(food2);
            foodClassList.add(food3);



        }else if(food.equalsIgnoreCase("dumplings")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Dumplings", R.drawable.dimsum);


            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("falafel")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Falafel", R.drawable.falafel);


            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("macarons")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Macarons", R.drawable.macaron);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("donuts")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Donuts", R.drawable.donut);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("soup")){


            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            // Soup 1
            FoodClass food1 = new FoodClass("Other Soups", R.drawable.miso_soup);


            // Soup 2
            FoodClass food2 = new FoodClass("Hot And Sour Soup", R.drawable.hot_n_sour_soup);



            foodClassList.add(food1);
            foodClassList.add(food2);


        }else if(food.equalsIgnoreCase("apple pie")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Apple Pie", R.drawable.apple_pie);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("burger")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Burger", R.drawable.burger);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("fish")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Fish", R.drawable.fish);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("sandwich")){


            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Sandwich", R.drawable.sandwich);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("ramen")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Ramen", R.drawable.ramen);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("burrito")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Burrito", R.drawable.burrito);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("omelette")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Omelette", R.drawable.omelette);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("pancakes")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Pancakes", R.drawable.pancake);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("french toast")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("French Toast", R.drawable.french_toast);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("onion rings")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Onion Rings", R.drawable.onion_ring);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("pizza")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            // Margherita Pizza
            FoodClass food1 = new FoodClass("Margherita Pizza", R.drawable.margherita_pizza);


            // Veg Pizza
            FoodClass food2 = new FoodClass("Veg Pizza", R.drawable.veg_pizza);

            // Chicken Pizza
            FoodClass food3 = new FoodClass("Chicken Pizza", R.drawable.non_veg_pizza);



            foodClassList.add(food1);
            foodClassList.add(food2);
            foodClassList.add(food3);


        }else if(food.equalsIgnoreCase("waffles")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Waffles", R.drawable.waffle);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("fried rice")){
            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Fried Rice", R.drawable.fried_rice);
            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("cup cakes")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Cupcakes", R.drawable.cupcake);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("sushi")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Sushi", R.drawable.sushi);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("samosa")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Samosa", R.drawable.samosa);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("tiramisu")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Tiramisu", R.drawable.tiramisu);

            foodClassList.add(food1);

        }else if(food.equalsIgnoreCase("hot dog")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            FoodClass food1 = new FoodClass("Hot Dog", R.drawable.hotdog);

            foodClassList.add(food1);


        }else if(food.equalsIgnoreCase("ice cream")){

            // Populate the foodClassList with data, for example:
            foodClassList.clear();
            // chocolate icecream
            FoodClass food1 = new FoodClass("Chocolate Ice Cream", R.drawable.chocolate_icecream);

            // strawberry icecream
            FoodClass food2 = new FoodClass("Strawberry Ice Cream", R.drawable.strawberry_icecream);

            // vanilla icecream
            FoodClass food3 = new FoodClass("Vanilla Ice Cream", R.drawable.vanilla_icecream);


            // others
            FoodClass food4 = new FoodClass("Other Flavors", R.drawable.other_icecream);


            foodClassList.add(food1);
            foodClassList.add(food2);
            foodClassList.add(food3);
            foodClassList.add(food4);

        }


        VarietyAdapter adapter = new VarietyAdapter(VarietyActivity.this, foodClassList);
        recyclerView.setAdapter(adapter);
    }
}