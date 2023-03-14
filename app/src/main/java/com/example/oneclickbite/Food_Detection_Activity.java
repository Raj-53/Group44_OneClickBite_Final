package com.example.oneclickbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Food_Detection_Activity extends AppCompatActivity {

    private static final String IMG_DATA_KEY = "img_data_key";
    ImageView FoodImg;
    TextView txtLabel;
    RadioButton radioYes, radioNo;
    Bitmap imgGet;


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
            String detected_food_label = iGet.getStringExtra("food_label");
            txtLabel.setText("Food detected as : " + detected_food_label);

        }

        radioYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fmOrder = getSupportFragmentManager();
                FragmentTransaction ftOrder = fmOrder.beginTransaction();
                ftOrder.add(R.id.orderContainer, new OrderFragment()).commit();
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
        if(imgGet != null){
            outState.putParcelable(IMG_DATA_KEY, imgGet);
        }
        outState.putBoolean("RadioYes", radioYes.isChecked());
        outState.putBoolean("RadioNo", radioNo.isChecked());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.containsKey(IMG_DATA_KEY)){
            imgGet = savedInstanceState.getParcelable(IMG_DATA_KEY);
            FoodImg.setImageBitmap(imgGet);
        }
        radioYes.setChecked(savedInstanceState.getBoolean("RadioYes"));
        radioNo.setChecked(savedInstanceState.getBoolean("RadioNo"));

    }
}