package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Food_Detection_Activity extends AppCompatActivity {

    ImageView FoodImg;
    TextView txtLabel;
    RadioButton radioYes, radioNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detection);

        FoodImg = findViewById(R.id.FoodImg);
        txtLabel = findViewById(R.id.txtLabel);
        radioYes = findViewById(R.id.radioYes);
        radioNo = findViewById(R.id.radioNo);

        Intent iGet = getIntent();
        if(iGet.hasExtra("image")){
           byte[] bImageArrayGet = iGet.getByteArrayExtra("image");
           Bitmap imgGet = BitmapFactory.decodeByteArray(bImageArrayGet, 0, bImageArrayGet.length);
           FoodImg.setImageBitmap(imgGet);
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
                if(radioYes.isActivated()){
                    radioNo.setVisibility(View.GONE);
                }
                else {
                    Toast.makeText(Food_Detection_Activity.this, "Please Capture/Select the image again", Toast.LENGTH_SHORT).show();
                    Intent temp = new Intent(Food_Detection_Activity.this, MainActivity.class);
                    startActivity(temp);
                }
            }
        });
    }
}