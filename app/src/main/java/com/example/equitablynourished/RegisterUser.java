package com.example.equitablynourished;

import androidx.appcompat.app.AppCompatActivity;//import android.support.v7.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private TextView title;
    private EditText email, fullname, number, address, password;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        title = (TextView) findViewById(R.id.title);
        title.setOnClickListener(this);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        email = (EditText) findViewById(R.id.email);
        fullname = (EditText) findViewById(R.id.fullname);
        number = (EditText) findViewById(R.id.number);
        address = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    //@SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.register:
                registerUser();
                break;
        }

    }

    private void registerUser() {
        String emailText = email.getText().toString().trim();
        String fullnameText = fullname.getText().toString().trim();
        String numberText = number.getText().toString().trim();
        String addressText = address.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        if (fullnameText.isEmpty()){
            fullname.setError("Full name is required");
            fullname.requestFocus();
            return;
        }

        if (emailText.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if (numberText.isEmpty()){
            number.setError("Email is required");
            number.requestFocus();
            return;
        }

        if (addressText.isEmpty()){
            address.setError("Email is required");
            address.requestFocus();
            return;
        }

        if (passwordText.isEmpty()){
            password.setError("Email is required");
            password.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            email.setError("Enter valid email");
            email.requestFocus();
            return;
        }

        if(passwordText.length() < 6){
            password.setError("Minimum length is 6 characters");
            password.requestFocus();
            return;
        }
    }
}