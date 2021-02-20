package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {
    // Numeric values for the different traits in the settings questions
    public static double age;
    public static double weight;
    public static double height;

    // Can be male, female, or other
    public static byte gender;

    // Booleans for whether a certain goal was selected to be used
    public static boolean increase_activity;
    public static boolean lose_weight;
    public static boolean build_muscle;
    public static boolean reduce_stress;
    public static boolean maintain_physique;
    public static boolean endurance;

    // Global variables for the component widgets
    EditText heightInput, weightInput, ageInput;
    RadioButton activity_button, weight_button, muscle_button, stress_button, physique_button, endurance_button;
    CheckBox male, female, other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void openHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void registerValues(View view) {
        System.out.println("Will store all the values in the variables");

        // Connect all the variable names for the components of the GUI to the actual component.
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        ageInput = findViewById(R.id.ageInput);
        activity_button = findViewById(R.id.activity_button);
        weight_button = findViewById(R.id.weight_button);
        muscle_button = findViewById(R.id.muscle_button);
        stress_button = findViewById(R.id.stress_button);
        physique_button = findViewById(R.id.physique_button);
        endurance_button = findViewById(R.id.endurance_button);
        male = findViewById(R.id.checkBox);
        female = findViewById(R.id.checkBox2);
        other = findViewById(R.id.checkBox3);

        // Store the values of each trait of the user by taking the input from settings tab.
        height = Double.parseDouble(heightInput.getText().toString());
        weight = Double.parseDouble(weightInput.getText().toString());
        age = Double.parseDouble(ageInput.getText().toString());

        // Returns corresponding values for which gender is selected
        if (male.isChecked()) {
            gender = 0;
        }
        else if (female.isChecked()) {
            gender = 1;
        }
        else if (other.isChecked()) {
            gender = 2;
        }

        // Returns corresponding values for which goals are selected.
        if (activity_button.isChecked()) {
            increase_activity = true;
        }
        if (weight_button.isChecked()) {
            lose_weight = true;
        }
        if (muscle_button.isChecked()) {
            build_muscle = true;
        }
        if (stress_button.isChecked()) {
            reduce_stress = true;
        }
        if (physique_button.isChecked()) {
            maintain_physique = true;
        }
        if (endurance_button.isChecked()) {
            endurance = true;
        }

        // Tests to make sure it is properly logged
        System.out.println("Values: " + age + weight + height + gender + increase_activity + lose_weight + build_muscle + reduce_stress + maintain_physique + endurance);
    }
}