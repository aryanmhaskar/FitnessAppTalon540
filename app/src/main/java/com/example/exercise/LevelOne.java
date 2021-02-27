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


public class LevelOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        System.out.println("run the bink python code");
        PyObject test = Python.getInstance().getModule("test");
        PyObject test2 = Python.getInstance().getModule("test2");
        test.call();
        test2.callAttr("test");
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

