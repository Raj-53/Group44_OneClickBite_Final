package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Food_Detection_Activity extends AppCompatActivity {

    ImageView FoodImg;
    TextView txtLabel;
    RadioButton radioGet, radioOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detection);

        FoodImg = findViewById(R.id.FoodImg);
        txtLabel = findViewById(R.id.txtLabel);
        radioGet = findViewById(R.id.radioYes);
        radioOrder = findViewById(R.id.radioNo);


        Intent iGet = getIntent();
        if(iGet.hasExtra("image")){
           byte[] bImageArrayGet = iGet.getByteArrayExtra("image");
           Bitmap imgGet = BitmapFactory.decodeByteArray(bImageArrayGet, 0, bImageArrayGet.length);
           FoodImg.setImageBitmap(imgGet);
        }

    }
}