package com.example.oneclickbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;



public class VideoRecipeInstructions extends AppCompatActivity {
    String food;
    YouTubePlayerView youTubePlayerView, youTubePlayerViewEnglish;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_recipe_instructions);
        Intent iGet = getIntent();
        food = iGet.getStringExtra("foodTag");
        Toast.makeText(this, food, Toast.LENGTH_SHORT).show();

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerViewEnglish = findViewById(R.id.youtube_player_view_English);
        getLifecycle().addObserver(youTubePlayerView);



        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                switch(food){
                    case "Chocolate Cake": {
                        String videoId = "J7bjH5IdMjc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Red Velvet Cake": {
                        String videoId = "Te3XsJgJyvg";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Carrot Cake": {
                        String videoId = "Ephxv6Ow2lU";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Strawberry Shortcake": {
                        String videoId = "hxUvHA_iHeA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Cheesecake": {
                        String videoId = "q4wUWqV8kjc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }

                    case "Garlic Bread": {
                        String videoId = "qO5Plwca1AE";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "French Fries": {
                        String videoId = "sghEBrgsTC4";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Veg Spaghetti": {
                        String videoId = "84I-RQQzjLA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Non-Veg Spaghetti": {
                        String videoId = "SUsE_-mNIys";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Lasagna": {
                        String videoId = "DhwGdJA-WiE&t=14s";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Mac and Cheese": {
                        String videoId = "g84NbZs5ayU";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Churros": {
                        String videoId = "5jMEWcdJcjk";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Tacos": {
                        String videoId = "E6elTjRtB2c";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Spring Rolls": {
                        String videoId = "cjtIawbqZQ8";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Chicken Wings": {
                        String videoId = "B2ftUXn0JxA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Chicken Curry": {
                        String videoId = "vaaY6GRmkDw";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Bruschetta": {
                        String videoId = "VTevpPJu5g4";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Greek Salad": {
                        String videoId = "DhwGdJA-WiE";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Caprese Salad": {
                        String videoId = "WmN-tiq6J6U";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Caesar Salad": {
                        String videoId = "KcPev4khHGw";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Dumplings": {
                        String videoId = "kJ18FBO92yc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Falafel": {
                        String videoId = "AIczG0gl1-I";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Macarons": {
                        String videoId = "6Agqo9iLwsw";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Donuts": {
                        String videoId = "GuI-6aWhVfI";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Other Soups": {
                        String videoId = "NDbDYsFelrw";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Hot And Sour Soup": {
                        String videoId = "aDQxH-KpCCc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Apple Pie": {
                        String videoId = "4u3GfSxzjpA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Burger": {
                        String videoId = "_q5GKCNZcHI";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Fish": {
                        String videoId = "k7SId7GSNw0";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                     case "Sandwich": {
                        String videoId = "jSIB3dbyZog";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Ramen": {
                        String videoId = "plTuwZva37k";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Burrito": {
                        String videoId = "9Xo7F74WDa4";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Omelette": {
                        String videoId = "sAa-CEl5Z-k";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Pancakes": {
                        String videoId = "Nt5T9DH_zS8";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "French Toast": {
                        String videoId = "4uFHkuJnc08";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Onion Rings": {
                        String videoId = "VpTNIGRn8_4";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Margherita Pizza": {
                        String videoId = "Xt3pRLPgI6I";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Veg Pizza": {
                        String videoId = "PK0czgdbHoY";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                     case "Chicken Pizza": {
                        String videoId = "x9WWRP8hMZc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Waffles": {
                        String videoId = "SxqG9sn4hsc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Fried Rice": {
                        String videoId = "hoZccEa0Pqo";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Cupcakes": {
                        String videoId = "foWdqKjjWoA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Sushi": {
                        String videoId = "aDQxH-KpCCc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                     case "Samosa": {
                        String videoId = "EKPAfUCn_Jo";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Tiramisu": {
                        String videoId = "YZHu1G8MjL0";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                     case "Hot Dog": {
                        String videoId = "jPqNIxtIrtA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Chocolate Ice Cream": {
                        String videoId = "F2wSFbXWzjI";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Strawberry Ice Cream": {
                        String videoId = "6I7x3tmZnNA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Vanilla Ice Cream": {
                        String videoId = "-sKYb2d3Z7Q";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Other Flavors": {
                        String videoId = "_isf3glQk0Q";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }

                }
            }
        });

        youTubePlayerViewEnglish.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                switch(food){
                    case "Chocolate Cake": {
                        String videoId = "4j2PUwO_puQ";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Red Velvet Cake": {
                        String videoId = "cMPUB3DUssA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Carrot Cake": {
                        String videoId = "zoyhs-EiJxE";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Strawberry Shortcake": {
                        String videoId = "MoNUQn8HfFU";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Cheesecake": {
                        String videoId = "ZYoYffXWiwk";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }

                    case "Garlic Bread": {
                        String videoId = "wBFrmiDDIek";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "French Fries": {
                        String videoId = "moaD22jhXo0";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Veg Spaghetti": {
                        String videoId = "TW1hwAzkZWo";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Non-Veg Spaghetti": {
                        String videoId = "I47pr0bCijk";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Lasagna": {
                        String videoId = "abmjDCk_wVQ";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Mac and Cheese": {
                        String videoId = "YxVZuuxxXxk";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Churros": {
                        String videoId = "bUViJkaQeaY";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Tacos": {
                        String videoId = "PGklx6OD_MM";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Spring Rolls": {
                        String videoId = "HJPRPEJY2WM";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Chicken Wings": {
                        String videoId = "2411pCkobQQ";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Chicken Curry": {
                        String videoId = "sH-juTnjm-Y";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Bruschetta": {
                        String videoId = "Q3xg35pcLyo";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Greek Salad": {
                        String videoId = "kwq4vl610iY";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Caprese Salad": {
                        String videoId = "gOcfUgd4ekA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Caesar Salad": {
                        String videoId = "IGlWE4AFQ5Q";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Dumplings": {
                        String videoId = "EKltq6jpFvk";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Falafel": {
                        String videoId = "aQD0ndQGpG0";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Macarons": {
                        String videoId = "5zgfdImm_VA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Donuts": {
                        String videoId = "OS1bu8p8GZk";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Other Soups": {
                        String videoId = "ck9qdj_d_4s";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Hot And Sour Soup": {
                        String videoId = "0hr_PlhClGg";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Apple Pie": {
                        String videoId = "KbyahTnzbKA";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Burger": {
                        String videoId = "5zd5GCr61nQ";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Fish": {
                        String videoId = "kurTjPcaNPE";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Sandwich": {
                        String videoId = "5iRnHiX6oTw";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Ramen": {
                        String videoId = "-dWpHngp_ug";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Burrito": {
                        String videoId = "f0AQD5fBXOU";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Omelette": {
                        String videoId = "EoufLVAAPSU";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Pancakes": {
                        String videoId = "FLd00Bx4tOk";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "French Toast": {
                        String videoId = "EARnchvnbVI";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Onion Rings": {
                        String videoId = "dcB5VU93AII";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Margherita Pizza": {
                        String videoId = "vcfNpDtVqOw";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Veg Pizza": {
                        String videoId = "TBrz3chSss0";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Chicken Pizza": {
                        String videoId = "Ar2TdluZxV8";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Waffles": {
                        String videoId = "Gg3SGj185aM";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Fried Rice": {
                        String videoId = "WYh2Ju4MfYE";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Cupcakes": {
                        String videoId = "YP8a6ugKQ6Y";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Sushi": {
                        String videoId = "joweUxpHaqc";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Samosa": {
                        String videoId = "3OZn-iCGf5s";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Tiramisu": {
                        String videoId = "7VTtenyKRg4";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Hot Dog": {
                        String videoId = "gygK-MYXHxY";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Chocolate Ice Cream": {
                        String videoId = "4rsLIcl7sW4";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Strawberry Ice Cream": {
                        String videoId = "KoWwoj35s38";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Vanilla Ice Cream": {
                        String videoId = "ZkZAQ2QLr7Q";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                    case "Other Flavors": {
                        String videoId = "7gJIyHnD710";
                        youTubePlayer.loadVideo(videoId, 0);
                        break;
                    }
                }
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
        youTubePlayerViewEnglish.release();
    }
}