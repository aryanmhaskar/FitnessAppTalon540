package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LevelOneTransition extends AppCompatActivity {

    Timer transitionTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_transition);

        transitionTimer = new Timer();
        transitionTimer.schedule(new TimerTask() {

            @Override
            public void run() {
            Intent intent = new Intent(LevelOneTransition.this, LevelOne.class);
            startActivity(intent);
            finish();
            }
        }, 17000);
    }
}