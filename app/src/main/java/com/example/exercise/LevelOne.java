package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.view.Window;
import android.view.WindowManager;
import android.content.pm.ActivityInfo;


public class LevelOne extends AppCompatActivity {

    int healthBar = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        if (healthBar == 4) {
            ImageView imageView = (ImageView) findViewById(R.id.imageViewFull);
            imageView.setVisibility(View.VISIBLE);
            ImageView imageView2 = (ImageView) findViewById(R.id.imageViewHealthy);
            imageView2.setVisibility(View.INVISIBLE);
            ImageView imageView3 = (ImageView) findViewById(R.id.imageViewHalf);
            imageView3.setVisibility(View.INVISIBLE);
            ImageView imageView4 = (ImageView) findViewById(R.id.imageViewEmpty);
            imageView4.setVisibility(View.INVISIBLE);
        }

        Button run = (Button)findViewById(R.id.levelOne);

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView enemy = (ImageView)findViewById(R.id.imageView8);
                enemy.setImageResource(R.drawable.animatedgif);
                AnimationDrawable runningGif = (AnimationDrawable)enemy.getDrawable();
                runningGif.start();
                healthBar --;
                if (healthBar == 3) {
                    ImageView imageView = (ImageView) findViewById(R.id.imageViewFull);
                    imageView.setVisibility(View.INVISIBLE);
                    ImageView imageView2 = (ImageView) findViewById(R.id.imageViewHealthy);
                    imageView2.setVisibility(View.VISIBLE);
                    ImageView imageView3 = (ImageView) findViewById(R.id.imageViewHalf);
                    imageView3.setVisibility(View.INVISIBLE);
                    ImageView imageView4 = (ImageView) findViewById(R.id.imageViewEmpty);
                    imageView4.setVisibility(View.INVISIBLE);
                }
                else if (healthBar == 2) {
                    ImageView imageView = (ImageView) findViewById(R.id.imageViewFull);
                    imageView.setVisibility(View.INVISIBLE);
                    ImageView imageView2 = (ImageView) findViewById(R.id.imageViewHealthy);
                    imageView2.setVisibility(View.INVISIBLE);
                    ImageView imageView3 = (ImageView) findViewById(R.id.imageViewHalf);
                    imageView3.setVisibility(View.VISIBLE);
                    ImageView imageView4 = (ImageView) findViewById(R.id.imageViewEmpty);
                    imageView4.setVisibility(View.INVISIBLE);
                }
                else if (healthBar == 1) {
                    ImageView imageView = (ImageView) findViewById(R.id.imageViewFull);
                    imageView.setVisibility(View.INVISIBLE);
                    ImageView imageView2 = (ImageView) findViewById(R.id.imageViewHealthy);
                    imageView2.setVisibility(View.INVISIBLE);
                    ImageView imageView3 = (ImageView) findViewById(R.id.imageViewHalf);
                    imageView3.setVisibility(View.INVISIBLE);
                    ImageView imageView4 = (ImageView) findViewById(R.id.imageViewEmpty);
                    imageView4.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}