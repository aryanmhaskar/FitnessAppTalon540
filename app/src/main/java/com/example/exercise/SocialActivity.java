package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
    }

    public void openHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}