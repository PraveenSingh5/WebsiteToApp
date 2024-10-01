package com.example.websitetoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 SharedPreferences sharedPreferences1 = getSharedPreferences("MySharedPref1",MODE_PRIVATE);
                 boolean check = sharedPreferences1.getBoolean("check",false);
                 if (check){
                     Intent intent = new Intent(SScreen.this, MainActivity.class);
                     startActivity(intent);
                     finish();
                 }else {
                     Intent intent = new Intent(SScreen.this, Sitename.class);
                     startActivity(intent);
                     finish();
                 }

             }
         },2000);

    }
}