package com.example.oneclickbite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.FileProvider;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oneclickbite.ml.Model;

import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.Category;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final int CAMERA_REQ_CODE = 100;
    private final int GALLERY_REQ_CODE = 200;
    private static final String IMAGE_KEY = "img_key";
    File camFile = null;
    ImageView img;
    Bitmap img1;
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

        if(savedInstanceState != null){
            byte[] imgData = savedInstanceState.getByteArray(IMAGE_KEY);
            if(imgData != null){
                img1 = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
                img.setImageBitmap(img1);
            }
        }

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imgCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    camFile = createCamFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (camFile != null) {
                    Uri camUri = FileProvider.getUriForFile(MainActivity.this, "com.example.oneclickbite.fileprovider", camFile);
                    imgCam.putExtra(MediaStore.EXTRA_OUTPUT, camUri);
                    startActivityForResult(imgCam, CAMERA_REQ_CODE);
                }
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
                    img1.compress(Bitmap.CompressFormat.JPEG, 50, bImage);
                    String detected_food_label = classifyImage(img1);
                    byte[] bImageArray = bImage.toByteArray();
                    iDetect.putExtra("image", bImageArray);
                    iDetect.putExtra("food_label",detected_food_label);
                    startActivity(iDetect);
                } else {
                    Toast.makeText(MainActivity.this, "Please Capture/Select an Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    private File createCamFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String camImageName = "JPEG_" + timeStamp + "_";
        File camDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        camFile = File.createTempFile(camImageName, ".jpeg", camDir);
        return camFile;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE);
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(img1 != null){
            ByteArrayOutputStream bImage = new ByteArrayOutputStream();
            img1.compress(Bitmap.CompressFormat.JPEG, 50, bImage);
            byte[] bImageArray = bImage.toByteArray();
            outState.putByteArray(IMAGE_KEY, bImageArray);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        byte[] imgData = savedInstanceState.getByteArray(IMAGE_KEY);
        if (imgData != null) {
            img1 = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
            img.setImageBitmap(img1);
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
                if (camFile != null) {
                    BitmapFactory.Options option = new BitmapFactory.Options();
                    option.inSampleSize = 4;
                    img1 = BitmapFactory.decodeFile(camFile.getAbsolutePath(), option);
                    img.setImageBitmap(img1);
                }else{
                    Toast.makeText(this, "Unable to Retrieve, Please Try again", Toast.LENGTH_SHORT).show();
                }
            }
            else if (requestCode == GALLERY_REQ_CODE) {
                // For Gallery
                if(data != null && data.getData() != null) {
                    Uri imgUri = data.getData();
                    try {
                        InputStream in = getContentResolver().openInputStream(imgUri);
                        BitmapFactory.Options option = new BitmapFactory.Options();
                        option.inSampleSize = 4;
                        img1 = BitmapFactory.decodeStream(in, null, option);
                        img.setImageBitmap(img1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}