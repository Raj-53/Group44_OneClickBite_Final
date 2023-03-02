package com.example.oneclickbite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private final int CAMERA_REQ_CODE = 100;
    private final int GALLERY_REQ_CODE = 200;
    ImageView img;
    Bitmap img1;
    AppCompatButton btnCamera, btnGallery, btnDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        btnCamera = findViewById(R.id.btnCamera);
        btnGallery = findViewById(R.id.btnGallery);
        btnDetect = findViewById(R.id.btnDetect);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imgCam =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(imgCam, CAMERA_REQ_CODE);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE);
            }
        });

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img1 != null) {
                    Intent iDetect = new Intent(MainActivity.this, Food_Detection_Activity.class);
                    ByteArrayOutputStream bImage = new ByteArrayOutputStream();
                    img1.compress(Bitmap.CompressFormat.JPEG, 100, bImage);
                    byte[] bImageArray = bImage.toByteArray();
                    iDetect.putExtra("image", bImageArray);
                    startActivity(iDetect);
                } else {
                    Toast.makeText(MainActivity.this, "Please Capture/Select an Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQ_CODE){
                // For Camera
                Bundle extras = data.getExtras();
                img1 = (Bitmap) extras.get("data");
                img.setImageBitmap(img1);
            }
            else if (requestCode == GALLERY_REQ_CODE) {
                // For Gallery
                if(data != null && data.getData() != null) {
                    Uri imgUri = data.getData();
                    try {
                        img1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgUri);
                        img.setImageBitmap(img1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//                img.setImageURI(data.getData());
            }
        }
    }
}