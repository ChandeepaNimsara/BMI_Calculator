package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("EXIT");
        dialog.setMessage("Do you want to exit from the app?");
        dialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        dialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
                System.exit(0);
            }
        });
        dialog.show();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_cal_button = (Button) findViewById(R.id.btn_cal);     //get button
        EditText text_age = (EditText) findViewById(R.id.age);           //get age
        EditText text_height = (EditText) findViewById(R.id.hei);        //get height
        EditText text_weight = (EditText) findViewById(R.id.wei);        //get weight

        btn_cal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text_age.getText().toString().equals("") || text_height.getText().toString().equals("") || text_weight.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter your details",Toast.LENGTH_LONG).show();
                }
                   else {
                     int age = Integer.parseInt(text_age.getText().toString()); //

                       if(18<=age){
                           double height = Double.parseDouble(text_height.getText().toString());
                           double weight = Double.parseDouble(text_weight.getText().toString());
                           double BMI = ((weight)/(Math.pow((height/100),2)));

                           Intent openSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                           openSecondActivity.putExtra("bmi",BMI);
                           startActivity(openSecondActivity);

                       }
                       else{
                           Toast.makeText(getApplicationContext(),"This calculator valid for only over 18-year people",Toast.LENGTH_LONG).show();
                       }
                }
            }
        });
    }

}