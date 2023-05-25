package com.example.lab2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtNumber;
    private Button btnRandom;
    private EditText txtMin;
    private EditText txtMax;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        //Anh xa
        txtNumber = (TextView) findViewById(R.id.txtResult);
        btnRandom= (Button) findViewById(R.id.btnRandom);
        txtMin = (EditText) findViewById(R.id.txtMin);
        txtMax = (EditText) findViewById(R.id.txtMax);
        btnBack = findViewById(R.id.btnBack);
        //Viet code
        btnRandom.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        };

    private void randomNumber(){
        Random random = new Random();
        int tMin;
        int tMax;
        if (txtMin.getText().toString().isEmpty()&&!txtMax.getText().toString().isEmpty()) {
            tMin = Integer.parseInt(txtMin.getHint().toString());
            tMax = Integer.parseInt(txtMax.getText().toString());

        } else if (txtMax.getText().toString().isEmpty()&&!txtMin.getText().toString().isEmpty()) {
            tMin = Integer.parseInt(txtMin.getText().toString());
            tMax = Integer.parseInt(txtMax.getHint().toString());
        } else if (!txtMin.getText().toString().isEmpty()&&!txtMax.getText().toString().isEmpty()) {
            tMin = Integer.parseInt(txtMin.getText().toString());
            tMax = Integer.parseInt(txtMax.getText().toString());
        } else {
            tMin = Integer.parseInt(txtMin.getHint().toString());
            tMax = Integer.parseInt(txtMax.getHint().toString());
        }
        if(tMin<tMax){
            int number = tMin+random.nextInt(tMax-tMin+1);
            txtNumber.setText(number+"");}
        else {
            int n = tMax;
            tMax = tMin;
            tMin = n ;
            int number = tMin+random.nextInt(tMax-tMin+1);
            txtNumber.setText(number+"");
            txtMax.setText(tMax+"");
            txtMin.setText(tMin+"");
        }
    }
    private void backController() {
        Intent intent = new Intent(this,MainController.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnRandom) {
            randomNumber();
        } else {
            backController();
        }
    }
}
