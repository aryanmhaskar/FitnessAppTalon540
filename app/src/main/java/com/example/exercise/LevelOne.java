package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LevelOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        Button run = (Button)findViewById(R.id.levelOne);

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView example = (ImageView)findViewById(R.id.imageView8);
                example.setImageResource(R.drawable.animatedgif);
                AnimationDrawable runningGif = (AnimationDrawable)example.getDrawable();
                runningGif.start();
            }
        });

    }

}

