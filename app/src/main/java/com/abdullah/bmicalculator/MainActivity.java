package com.abdullah.bmicalculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    LinearLayout male, female;
    TextView heightView, weightView, ageView;

    ImageButton increaseWeight, decreaseWeight, increaseAge, decreaseAge;

    SeekBar seekBarHeight;

    private boolean isMale = true;
    private int height = 180;
    private int weight = 70;
    private int age = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareElements();
        setData();


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMale = true;
                setData();
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMale = false;
                setData();
            }
        });


        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                height = progress;
                setData();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setScrollBarSize(200);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        increaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight < 300) {
                    weight++;
                    setData();
                }
            }
        });
        decreaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight > 1) {
                    weight--;
                    setData();
                }
            }
        });

        increaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (age < 150) {
                    age++;
                    setData();
                }
            }
        });
        decreaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (age > 0) {
                    age--;
                    setData();
                }
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BMIResultActivity.class);
                intent.putExtra("isMale", isMale);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });

    }

    private void setData() {
        if (isMale) {
            female.setAlpha(0.4f);
            male.setAlpha(1f);
        } else {
            female.setAlpha(1f);
            male.setAlpha(0.4f);
        }
        heightView.setText(String.valueOf(height));
        weightView.setText(String.valueOf(weight));
        ageView.setText(String.valueOf(age));
        seekBarHeight.setProgress(height);
    }

    private void declareElements() {
        btnCalculate = findViewById(R.id.calc_btn);
        male = findViewById(R.id.select_male);
        female = findViewById(R.id.select_female);
        heightView = findViewById(R.id.height);
        weightView = findViewById(R.id.weight);
        ageView = findViewById(R.id.age);
        increaseWeight = findViewById(R.id.plus_weight_btn);
        decreaseWeight = findViewById(R.id.minus_weight_btn);
        increaseAge = findViewById(R.id.plus_age_btn);
        decreaseAge = findViewById(R.id.minus_age_btn);
        seekBarHeight = findViewById(R.id.height_bar);
    }
}