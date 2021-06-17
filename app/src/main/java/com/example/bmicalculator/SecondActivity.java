package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        double BMI = bundle.getDouble("bmi");

        String text = null;
        String color = null;

        if (BMI > 0) {
            if (BMI < 16) {
                text = "SEVERE THINNESS";
                color = "#E08280";
            } else if ((16 <= BMI && BMI < 17)) {
                text = "MODERATE THINNESS";
                color = "#HB71C1C";
            } else if ((17 <= BMI && BMI < 18.5)) {
                text = "MILD THINNESS";
                color = "#FFB300";
            } else if ((18.5 <= BMI && BMI < 25)) {
                text = "NORMAL";
                color = "#388E3B";
            } else if ((25 <= BMI && BMI < 30)) {
                text = "OVERWEIGHT";
                color = "#FFEB3B";
            } else if ((30 <= BMI && BMI < 35)) {
                text = "OBESE CLASS I";
                color = "#F4511E";
            } else if ((40 <= BMI && BMI < 40)) {
                text = "OBESE CLASS II";
                color = "#FF747A";
            } else if ((BMI >= 40)) {
                text = "OBESE CLASS III";
                color = "#C62828";
            }

            TextView textView_color = (TextView) findViewById(R.id.text_color);
            textView_color.setText(text);
            textView_color.setTextColor(Color.parseColor(color));

            BigDecimal bigDecimal = new BigDecimal(Double.toString(BMI));
            bigDecimal = bigDecimal.setScale(1, RoundingMode.HALF_UP);

            TextView textBMI = (TextView) findViewById(R.id.bmi_val);
            textBMI.setText("BMI=" + bigDecimal + "kg/m2");
            textBMI.setTextColor(Color.parseColor("#000000"));
        }
        else {
            Toast.makeText(getApplicationContext(), "Inputs are invalid", Toast.LENGTH_LONG).show();
        }
    }
}
