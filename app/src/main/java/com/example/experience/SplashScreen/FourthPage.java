package com.example.experience.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.experience.MainActivity;
import com.example.experience.R;

public class FourthPage extends AppCompatActivity {
    String prevStarted = "yes";
    ViewPager slidePager;
    PagerAdapter adapter;
    ImageView img_next;

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            if(img_next.isEnabled()){
                moveToSecondary();
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);
        img_next = findViewById(R.id.img_next);
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResume();
            }
        });
    }
    public void moveToSecondary(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}