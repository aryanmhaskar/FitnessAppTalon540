package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openShop(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
        //Creates variable and references ShopActivity.com file to open
    }
    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openPlay (View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    public void openSocial(View view) {
        Intent intent = new Intent(this, SocialActivity.class);
        startActivity(intent);
    }
}