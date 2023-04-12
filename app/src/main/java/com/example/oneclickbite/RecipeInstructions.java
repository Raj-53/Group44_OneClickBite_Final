package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeInstructions extends AppCompatActivity {

    TextView heading;
    Button button1, button2, button3, button4, button5;

    String food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_instructions);

        heading = findViewById(R.id.heading);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);


        Intent iGet = getIntent();

        food = iGet.getStringExtra("foodTag");

        heading.append(" FOR " + food.toUpperCase());
//
//        Toast.makeText(this, food, Toast.LENGTH_SHORT).show();

        Intent recipeIntent = new Intent(RecipeInstructions.this, RecipeDetail.class);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeIntent.putExtra("EXTRA_URL", "https://www.allrecipes.com/recipe/231939/honey-glazed-chicken/");
                startActivity(recipeIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}