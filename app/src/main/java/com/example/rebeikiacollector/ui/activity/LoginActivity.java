package com.example.rebeikiacollector.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.repository.local.PreferencesManager;
import com.example.rebeikiacollector.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    Button Login;
    EditText emailetxt, passwordetxt;
    String emailtxt, passtxt;
    private LoginViewModel viewModel;
    PreferencesManager sharedpref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login = findViewById(R.id.loginbtn);
        emailetxt = findViewById(R.id.emailstxt);
        passwordetxt = findViewById(R.id.passtxt);
        sharedpref = new PreferencesManager(this);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        observeData();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginvalidation();
            }
        });
    }

    private void observeData() {
        viewModel.loginResponse.observe(this, loginResponse -> {

            sharedpref.savetoken(loginResponse.getToken().getToken());
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();


        });
        viewModel.getMsgError().observe(this, s -> {
            Toast.makeText(this, "user name or password is incorrect", Toast.LENGTH_LONG).show();
        });
    }

    private void loginvalidation() {
        emailtxt = emailetxt.getText().toString().trim();
        passtxt = passwordetxt.getText().toString().trim();
        if (emailtxt.isEmpty()) {
            emailetxt.setError("email is required");
            emailetxt.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailtxt).matches()) {
            emailetxt.setError("enter a valid email");
            emailetxt.requestFocus();
            return;
        }
        if (passtxt.isEmpty()) {
            passwordetxt.setError("enter your password");
            passwordetxt.requestFocus();
            return;
        }
        if (passtxt.length() < 6) {
            passwordetxt.setError("password should be at least 6 character ");
            passwordetxt.requestFocus();
            return;
        }
        viewModel.login(emailtxt, passtxt);


    }
}
