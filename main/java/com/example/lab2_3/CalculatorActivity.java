package com.example.lab2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kotlin.jvm.Volatile;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private Button congButton;
    private Button truButton;
    private Button nhanButton;
    private Button chiaButton;
    private EditText so1;
    private EditText so2;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Anh xa
        txtResult = (TextView) findViewById(R.id.txtResult);
        congButton = (Button) findViewById(R.id.congButton);
        truButton = (Button) findViewById(R.id.truButton);
        nhanButton = (Button) findViewById(R.id.nhanButton);
        chiaButton = (Button) findViewById(R.id.chiaButton);
        so1 = (EditText) findViewById(R.id.num1);
        so2 = (EditText) findViewById(R.id.num2);
        btnBack = (Button)findViewById(R.id.btnBack);
        //vietCode
//        int number1 = Integer.parseInt(so1.getText().toString());
//        int number2 = Integer.parseInt(so2.getText().toString());
        btnBack.setOnClickListener(this);
        congButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1;
                int number2;
                if (so1.getText().toString().isEmpty()||so2.getText().toString().isEmpty()){
                    txtResult.setText("Vui lòng nhập đủ 2 số");
                } else {
                    number1 = Integer.parseInt(so1.getText().toString());
                    number2 = Integer.parseInt(so2.getText().toString());
                    int result = number1 + number2;
                    txtResult.setText(result+"");
                }
            }
        });
        truButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1;
                int number2;
                if (so1.getText().toString().isEmpty()||so2.getText().toString().isEmpty()){
                    txtResult.setText("Vui lòng nhập đủ 2 số");
                } else {
                    number1 = Integer.parseInt(so1.getText().toString());
                    number2 = Integer.parseInt(so2.getText().toString());
                    int result = number1 - number2;
                    txtResult.setText(result+"");
                }
            }
        });
        nhanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1;
                int number2;
                if (so1.getText().toString().isEmpty()||so2.getText().toString().isEmpty()){
                    txtResult.setText("Vui lòng nhập đủ 2 số");
                } else {
                    number1 = Integer.parseInt(so1.getText().toString());
                    number2 = Integer.parseInt(so2.getText().toString());
                    int result = number1 * number2;
                    txtResult.setText(result+"");
                }
            }
        });
        chiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (so1.getText().toString().isEmpty()||so2.getText().toString().isEmpty()){
                    txtResult.setText("Vui lòng nhập đủ 2 số");
                } else {
                    float number1 = Float.parseFloat(so1.getText().toString());
                    float number2 = Float.parseFloat(so2.getText().toString());
                    if (number2 == 0) {
                        txtResult.setText("Không được chia cho 0");
                    } else {
                        float result = number1 / number2;
                        txtResult.setText(result + "");
                    }
                }
            }
        });
    }
    private void backController() {
        Intent intent = new Intent(this,MainController.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnBack){
            backController();
        }
    }
}
