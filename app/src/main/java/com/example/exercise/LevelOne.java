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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class LevelOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        Python.start(new AndroidPlatform(getApplicationContext()));
        PyObject test2 = Python.getInstance().getModule("test2");
        test2.callAttr("test");


        PyObject CVD3 = Python.getInstance().getModule("CVD3");
        CVD3.callAttr("computer_vision_module");

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

