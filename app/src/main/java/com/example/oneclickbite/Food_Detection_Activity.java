package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;

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
    RadioButton radioGet, radioOrder;
    Button cook1,order1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detection);

        FoodImg = findViewById(R.id.FoodImg);
        txtLabel = findViewById(R.id.txtLabel);
        radioGet = findViewById(R.id.radioYes);
        radioOrder = findViewById(R.id.radioNo);
        cook1=findViewById(R.id.cook);
        order1=findViewById(R.id.order);

        Intent iGet = getIntent();
        if(iGet.hasExtra("image")){
           byte[] bImageArrayGet = iGet.getByteArrayExtra("image");
           Bitmap imgGet = BitmapFactory.decodeByteArray(bImageArrayGet, 0, bImageArrayGet.length);
           FoodImg.setImageBitmap(imgGet);
        }
radioGet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        cook1.setVisibility(View.VISIBLE);
        order1.setVisibility(View.VISIBLE);
        radioOrder.setChecked(false);
    }
});
        radioOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Food_Detection_Activity.this, "Please click the image again", Toast.LENGTH_SHORT).show();
                Intent temp = new Intent(Food_Detection_Activity.this, MainActivity.class);
                startActivity(temp);
            }
        });
    }
}