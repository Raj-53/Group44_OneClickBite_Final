package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.util.ArrayList;

public class RecipeDetail extends AppCompatActivity {

    RecipeExtractor recipeExtractor;
    AppCompatButton btnIngredients;
    private TextView recipeTitleView, cuisineView, timeView;

    private String recipeTitle = "";
    private String recipeCuisine = "";
    private String recipeTime = "";
    ArrayList<String> ingrs;
    ArrayList<String> steps;

    private RecyclerView recView, recView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        recipeTitleView = (TextView) findViewById(R.id.recipeTitle);
        cuisineView = (TextView) findViewById(R.id.cuisineView);
        timeView = (TextView) findViewById(R.id.timeView);
        recView = (RecyclerView) findViewById(R.id.recView);
        recView2 = (RecyclerView) findViewById(R.id.recView2);
        btnIngredients = findViewById(R.id.btnIngredients);

        // set layout manager for recycler view
        LinearLayoutManager llm1 = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager llm2 = new LinearLayoutManager(getApplicationContext());
        recView.setLayoutManager(llm1);
        recView2.setLayoutManager(llm2);

        cuisineView.setText("Cuisine: ");
        timeView.setText("Time: ");

        Intent recipeIntent = getIntent();
        String url = recipeIntent.getStringExtra("EXTRA_URL");

        // check for connectivity
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if(networkInfo == null || !networkInfo.isConnected()){
            Toast.makeText(this, "You'll need to connect to the Internet for this service", Toast.LENGTH_SHORT).show();
        }

        if(url.isEmpty()){
            Toast.makeText(this, "No URL received", Toast.LENGTH_SHORT).show();
        } else{
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            // call recipe extractor
                            recipeExtractor = new RecipeExtractor();

                            recipeExtractor.setResponseData(response);

                            // call recipeScrape
                            int startIndex = url.indexOf("//") + 2; // start index of the substring
                            int endIndex = url.indexOf(".com"); // end index of the substring
                            String domain = url.substring(startIndex, endIndex);

                            if (domain != null && domain.startsWith("www.")) {
                                domain = domain.substring(4);
                            }

                            try {
                                switch (domain) {
                                    case "addapinch":
                                        recipeExtractor.scrapeData1();
                                        break;
                                    case "lifeloveandsugar":
                                        recipeExtractor.scrapeData2();
                                        break;
                                    case "natashaskitchen":
                                        recipeExtractor.scrapeData3();
                                        break;
                                    case "eitanbernath":
                                        recipeExtractor.scrapeData4();
                                        break;
                                    case "thespruceeats":
                                        recipeExtractor.scrapeData5();
                                        break;
                                    case "allrecipes":
                                        recipeExtractor.scrapeData6();
                                        break;
                                    case "delish":
                                        recipeExtractor.scrapeData7();
                                        break;
                                    case "pinchofyum":
                                        recipeExtractor.scrapeData8();
                                        break;
                                    default:
                                        Log.i("MyLog", domain);
                                        Toast.makeText(RecipeDetail.this, "Domain not in database!", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            } catch (IOException e){
                                Toast.makeText(RecipeDetail.this, "Error in parsing data!", Toast.LENGTH_SHORT).show();
                            }


                            // get fetched data
                            recipeTitle = recipeExtractor.getRecipeTitle();
                            recipeCuisine = recipeExtractor.getRecipeCuisine();
                            recipeTime = recipeExtractor.getRecipeTime();

                            ingrs = recipeExtractor.getIngrs();
                            steps = recipeExtractor.getRecipe();

                            // setting views
                            recipeTitleView.setText(recipeTitle);
                            cuisineView.append(recipeCuisine);
                            timeView.append(recipeTime);

                            CustomAdapter adapter = new CustomAdapter(RecipeDetail.this, ingrs);
                            recView.setAdapter(adapter);

                            CustomAdapter adapter2 = new CustomAdapter(RecipeDetail.this, steps);
                            recView2.setAdapter(adapter2);


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
        }

        btnIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PackageManager pm =  getPackageManager();
                //check if Blinkit is installed
                Intent iBlinkit = pm.getLaunchIntentForPackage("com.grofers.customerapp");
                if (iBlinkit == null) {
                    // Blinkit app is not installed, open the play store for download
                    iBlinkit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.grofers.customerapp"));
                }

                //check if Zepto is installed
                Intent iZepto = pm.getLaunchIntentForPackage("com.zeptoconsumerapp");
                if (iZepto == null) {
                    // Zepto app is not installed, open the play store for download
                    iZepto = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.zeptoconsumerapp"));
                }


                Intent choose = Intent.createChooser(iBlinkit, "Choose an app to order Ingredients: ");
                choose.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {iBlinkit, iZepto});
                choose.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(choose);

            }
        });

    }
}