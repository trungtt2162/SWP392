package com.example.lab2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainController extends AppCompatActivity implements View.OnClickListener{

    private Button btnBai1;
    private Button btnBai2;
    private Button btnBai3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_controller);

        btnBai1 = findViewById(R.id.Bai1);
        btnBai2 = findViewById(R.id.Bai2);
        btnBai3 = findViewById(R.id.Bai3);

        btnBai1.setOnClickListener(this);
        btnBai2.setOnClickListener(this);
        btnBai3.setOnClickListener(this);
    }
    private void clickBai1() {
        Intent intent = new Intent(this,CalculatorActivity.class);
        startActivity(intent);
        finish();
    }
    private void clickBai2() {
        Intent intent = new Intent(this,RandomActivity.class);
        startActivity(intent);
        finish();
    }
    private void clickBai3() {
        Intent intent = new Intent(this,SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.Bai1){
            clickBai1();
        } else if (v.getId()==R.id.Bai2) {
            clickBai2();
        } else {
            clickBai3();
        }
    }
}
