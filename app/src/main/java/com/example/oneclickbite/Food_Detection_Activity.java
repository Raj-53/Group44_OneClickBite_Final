package com.example.oneclickbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Food_Detection_Activity extends AppCompatActivity {

    private static final String IMG_DATA_KEY = "img_data_key";
    private Uri imageUri;
    ImageView FoodImg;
    TextView txtLabel;
    RadioButton radioYes, radioNo;
    Bitmap imgGet;
    String detected_food_label;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detection);

        FoodImg =  findViewById(R.id.FoodImg);
        txtLabel =  findViewById(R.id.txtLabel);
        radioYes = findViewById(R.id.radioYes);
        radioNo =  findViewById(R.id.radioNo);

        Intent iGet = getIntent();
        if(iGet.hasExtra("image")){
           byte[] bImageArrayGet = iGet.getByteArrayExtra("image");
           imgGet = BitmapFactory.decodeByteArray(bImageArrayGet, 0, bImageArrayGet.length);
           FoodImg.setImageBitmap(imgGet);
            Log.d("Food orient", String.valueOf(FoodImg.getRotation()));
        }

        // getting detected food label
        if(iGet.hasExtra("food_label")){
            detected_food_label = iGet.getStringExtra("food_label");

            if(detected_food_label.contains("cake") || detected_food_label.contains("Cake")){
                detected_food_label = "Cake";
                txtLabel.setText("Food detected as : " + detected_food_label);
            }else if(detected_food_label.contains("Spaghetti") || detected_food_label.contains("Lasagna") || detected_food_label.contains("Macaroni")){
                detected_food_label = "Pasta";
                txtLabel.setText("Food detected as : " + detected_food_label);
            }else if(detected_food_label.contains("Salad")){
                detected_food_label = "Salad";
                txtLabel.setText("Food detected as : " + detected_food_label);
            }else if(detected_food_label.contains("Soup")){
                detected_food_label = "Soup";
                txtLabel.setText("Food detected as : " + detected_food_label);
            }else if(detected_food_label.contains("burger")){
                detected_food_label = "Burger";
                txtLabel.setText("Food detected as : " + detected_food_label);
            }else if(detected_food_label.contains("Sandwich")){
                detected_food_label = "Sandwich";
                txtLabel.setText("Food detected as : " + detected_food_label);
            }else if(detected_food_label.contains("Fish")){
                detected_food_label = "fish";
                txtLabel.setText("Food detected as : " + detected_food_label);
            }else {
                txtLabel.setText("Food detected as : " + detected_food_label);
            }

        }

        radioYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fmOrder = getSupportFragmentManager();
                FragmentTransaction ftOrder = fmOrder.beginTransaction();

                // Create a new instance of OrderFragment and set detected_food_label value
                OrderFragment orderFragment = new OrderFragment();
                orderFragment.setDetectedFoodLabel(detected_food_label);
                ftOrder.add(R.id.orderContainer, orderFragment).commit();
                radioNo.setChecked(false);

            }
        });
        radioNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(Food_Detection_Activity.this, "Please Capture/Select the image again", Toast.LENGTH_SHORT).show();
                    Intent temp = new Intent(Food_Detection_Activity.this, MainActivity.class);
                    temp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(temp);
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (imageUri != null) {
            outState.putString(IMG_DATA_KEY, imageUri.toString());
        }
        outState.putBoolean("RadioYes", radioYes.isChecked());
        outState.putBoolean("RadioNo", radioNo.isChecked());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey(IMG_DATA_KEY)) {
            imageUri = Uri.parse(savedInstanceState.getString(IMG_DATA_KEY));
            if (imageUri != null) {
                FoodImg.setImageURI(imageUri);
            }
        }
        radioYes.setChecked(savedInstanceState.getBoolean("RadioYes"));
        radioNo.setChecked(savedInstanceState.getBoolean("RadioNo"));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent temp = new Intent(Food_Detection_Activity.this, MainActivity.class);
        temp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(temp);
    }
}