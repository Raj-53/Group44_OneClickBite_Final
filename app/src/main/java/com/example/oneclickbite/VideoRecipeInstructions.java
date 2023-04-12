package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class VideoRecipeInstructions extends AppCompatActivity {

    String food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_recipe_instructions);

        Intent iGet = getIntent();

        food = iGet.getStringExtra("foodTag");

        Toast.makeText(this, food, Toast.LENGTH_SHORT).show();
    }
}