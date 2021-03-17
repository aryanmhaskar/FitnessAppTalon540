package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


public class LevelOne extends AppCompatActivity {

    int healthBar = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        Python.start(new AndroidPlatform(getApplicationContext()));

        PyObject CVD3 = Python.getInstance().getModule("CVD3");
        CVD3.callAttr("computer_vision_module");

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
                ImageView example = (ImageView)findViewById(R.id.imageView8);
                example.setImageResource(R.drawable.animatedgif);
                AnimationDrawable runningGif = (AnimationDrawable)example.getDrawable();
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