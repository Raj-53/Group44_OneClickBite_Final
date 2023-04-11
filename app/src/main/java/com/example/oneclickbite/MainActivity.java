package com.example.oneclickbite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.oneclickbite.ml.Model;

import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.Category;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQ_CODE = 100;
    private static final int STORAGE_CODE = 30;
    private static final int GALLERY_REQ_CODE = 200;
    private static final String IMAGE_KEY = "img_key";
    File camFile = null;
    String camFilePath, detected_food_label;
    ImageView img;
    Bitmap bitmap1;
    AppCompatButton btnCamera, btnGallery, btnDetect;

    private Double max = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
        btnCamera = (AppCompatButton) findViewById(R.id.btnCamera);
        btnGallery = (AppCompatButton) findViewById(R.id.btnGallery);
        btnDetect = (AppCompatButton) findViewById(R.id.btnDetect);

        if (savedInstanceState != null) {
            byte[] imgData = savedInstanceState.getByteArray(IMAGE_KEY);
            if (imgData != null ) {
                bitmap1 = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
                img.setImageBitmap(bitmap1);
            }
        }

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED ){
                    Intent imgCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    try {
                        camFile = createCamFile();
                        camFilePath = camFile.getAbsolutePath(); // save the file path
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (camFile != null) {
                        Uri camUri = FileProvider.getUriForFile(MainActivity.this, "com.example.oneclickbite.fileprovider", camFile);
                        imgCam.putExtra(MediaStore.EXTRA_OUTPUT, camUri);
                        startActivityForResult(imgCam, CAMERA_REQ_CODE);
                    }
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
                }
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent();
                iGallery.setType("image/*");
                iGallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(iGallery, "Select Image "), GALLERY_REQ_CODE);
            }
        });

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img.getDrawable() != null) {
                    BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
                    Bitmap bitmap = drawable.getBitmap();

                    // Get the resized bitmap
                    int maxWidth = 1000;
                    int maxHeight = 1000;
                    Bitmap resizedBitmap = getResizedBitmap(bitmap, maxWidth, maxHeight);
                    detected_food_label = classifyImage(resizedBitmap);
                    ByteArrayOutputStream bStream = new ByteArrayOutputStream();
                    resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bStream);

                    byte[] byteArray = bStream.toByteArray();

                    Intent iDetect = new Intent(MainActivity.this, Food_Detection_Activity.class);

                    iDetect.putExtra("image", byteArray);
                    iDetect.putExtra("food_label", detected_food_label);
                    startActivity(iDetect);
                } else {
                    Toast.makeText(MainActivity.this, "Please Capture/Select an Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public Bitmap getResizedBitmap(Bitmap bitmap, int maxWidth, int maxHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxWidth;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxHeight;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }


    private String classifyImage(Bitmap image) {
        try {
            Model model = Model.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorImage img = TensorImage.fromBitmap(image);

            // Runs model inference and gets result.
            Model.Outputs outputs = model.process(img);
            List<Category> probability = outputs.getProbabilityAsCategoryList();
//            Log.i("MYLOG", probability.get(0).toString());
            // Releases model resources if no longer used.
            model.close();

            String result_label = "";

            for (int i = 0; i < 45; i++) {
                String s = probability.get(i).toString();

                // Extract category name
                String category_name = s.split("\"")[1];
                category_name = capitalizeWords(category_name);

                // Extract score
                Double score = Double.parseDouble(s.split("=")[2].replaceAll("[^\\d.]", ""));

                if(max < score){
                    max = score;
                    result_label = category_name;
//                    Log.i("MYLOG","Max : " + max);
                }

            }

            return result_label;

    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String capitalizeWords(String str) {
        String[] words = str.split("_");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase());
            sb.append(word.substring(1));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);  // Remove the last underscore
        return sb.toString();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (img != null) {
            img.setImageDrawable(null);
        }
    }

    private File createCamFile() throws IOException{
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm ss").format(new Date());
        String camImageName = "JPEG_" + timeStamp + "_";
        File camDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        camFile = File.createTempFile(camImageName, ".jpeg", camDir);
        return camFile;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(img != null && img.getDrawable() != null){
            BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
            bitmap1 = drawable.getBitmap();
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
            byte[] byteArray = bStream.toByteArray();
            outState.putByteArray(IMAGE_KEY, byteArray);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        byte[] imgData = savedInstanceState.getByteArray(IMAGE_KEY);
        if (imgData != null && img != null) {
            bitmap1 = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
            img.setImageBitmap(bitmap1);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQ_CODE) {
                    if (camFilePath != null) {
                        Glide.with(this)
                                .load(camFilePath)
                                .override(500, 500)
                                .into(img);
                    } else {
                        Log.d("camera", "Failed to save camera image");
                    }
            }
            else if (requestCode == GALLERY_REQ_CODE) {
                // For Gallery
                if(data != null && data.getData() != null) {
                    Uri imgUri = data.getData();
                    if(imgUri != null){
                        Glide.with(this)
                                .load(imgUri)
                                .override(500, 500)
                                .into(img);
                    }else{
                        Log.d("imgUri", "imgUri is null");
                    }
                }else{
                    Log.d("data", "data is null");
                }
            }else{
                Log.d("reqCode", "Unknown Request code");
            }
        }else{
            Log.d("Result Ok", "Result code is not ok");
        }
    }
}