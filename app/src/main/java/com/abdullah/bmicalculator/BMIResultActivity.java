package com.abdullah.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMIResultActivity extends AppCompatActivity {

    TextView caseResult, bmiResult, msgResult;
    ImageView bmiImage;

    Button backBtn;

    private void viewImage(boolean isMale, double bmi) {
        if (isMale) {
            if (bmi < 18.5) {
                bmiImage.setImageResource(R.drawable.male_underweight);
            } else if (bmi >= 18.5 && bmi < 25) {
                bmiImage.setImageResource(R.drawable.male_normal);
            } else if (bmi >= 25 && bmi < 30) {
                bmiImage.setImageResource(R.drawable.male_overweight);
            } else {
                bmiImage.setImageResource(R.drawable.male_obese);
            }
        } else {
            if (bmi < 18.5) {
                bmiImage.setImageResource(R.drawable.female_underweight);
            } else if (bmi >= 18.5 && bmi < 25) {
                bmiImage.setImageResource(R.drawable.female_normal);
            } else if (bmi >= 25 && bmi < 30) {
                bmiImage.setImageResource(R.drawable.female_overweight);
            } else {
                bmiImage.setImageResource(R.drawable.female_obese);
            }
        }
    }

    private void caseResult(double bmi) {
        String result = "";
        if (bmi < 18.5) {
            caseResult.setText("Underweight");
            caseResult.setTextColor(getResources().getColor(R.color.underweight));
        } else if (bmi >= 18.5 && bmi < 25) {
            caseResult.setText("Normal");
            caseResult.setTextColor(getResources().getColor(R.color.normal));
        } else if (bmi >= 25 && bmi < 30) {
            caseResult.setText("Overweight");
            caseResult.setTextColor(getResources().getColor(R.color.overweight));
        } else {
            caseResult.setText("Obese");
            caseResult.setTextColor(getResources().getColor(R.color.obese));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        declareElements();
        Intent intent = getIntent();
        boolean isMale = intent.getBooleanExtra("isMale", true);
        int height = intent.getIntExtra("height", 180);
        int weight = intent.getIntExtra("weight", 70);
        int age = intent.getIntExtra("age", 30);

        double bmi = (weight / ((height * height) / 10000));

        caseResult(bmi);
        bmiResult.setText(String.valueOf(bmi));
        msgResult.setText("Your BMI is " + bmi);
        viewImage(isMale, bmi);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void declareElements() {
        backBtn = findViewById(R.id.re_calc);
        caseResult = findViewById(R.id.case_result);
        bmiResult = findViewById(R.id.bmi_result);
        msgResult = findViewById(R.id.msg_result);
        bmiImage = findViewById(R.id.img_result);
    }
}