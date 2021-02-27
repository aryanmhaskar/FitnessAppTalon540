package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class LevelOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        System.out.println("run the bink python code");
        PyObject test = Python.getInstance().getModule("test");
        PyObject test2 = Python.getInstance().getModule("test2");
        test.call();
        test2.callAttr("test");
    }
}
