package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipeOption extends AppCompatActivity {

    Button textRecipe, videoRecipe;
    String food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_option);

        textRecipe = findViewById(R.id.getRecipe);
        videoRecipe = findViewById(R.id.getVidRecipe);

        Intent iGet = getIntent();

        food = iGet.getStringExtra("foodTag");

        textRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeOption.this, RecipeInstructions.class);
                intent.putExtra("foodTag",food);
                startActivity(intent);
            }
        });

        videoRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeOption.this, VideoRecipeInstructions.class);
                intent.putExtra("foodTag",food);
                startActivity(intent);
            }
        });
    }
}