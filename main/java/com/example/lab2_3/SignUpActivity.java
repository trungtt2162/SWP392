package com.example.lab2_3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    //View
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView tvAlreadyAccount;
    private Button btnSignUp;
    private Button btnBack;
    //Notify
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Reference from layout
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnBack = findViewById(R.id.btnBack);
        // Register event
        tvAlreadyAccount.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }
    private boolean checkInput() {
        // Username
        if (TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(etConfirmPassword.getText().toString())) {
            etConfirmPassword.setError(REQUIRE);
            return false;
        }
        if (!TextUtils.equals(etPassword.getText().toString(),
                              etConfirmPassword.getText().toString())){
            Toast.makeText(this,"Password are not match",Toast.LENGTH_LONG).show();;
            return false;
        }
        // Valid
        return true;
    }
    private void signUp() {
        //Invalid
        if (!checkInput()) {
            return;
        } else {
            Toast.makeText(this,"Sign Up Success",Toast.LENGTH_LONG).show();
        }
    }
    private void signInForm() {
        Intent intent = new Intent(this,SignInActivity.class);
        startActivity(intent);
        finish();
    }

    private void backController() {
        Intent intent = new Intent(this,MainController.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//
//            case v.getId()==R.id.btnSignUp:
//                signUp();
//                break;
//            case R.id.tvAlreadyAccount:
//                signInForm();
//                break;
//        }
        if (v.getId()==R.id.btnSignUp){
            signUp();
        } else if (v.getId()==R.id.tvAlreadyAccount){
            signInForm();
        } else {
            backController();
        }
    }
}
