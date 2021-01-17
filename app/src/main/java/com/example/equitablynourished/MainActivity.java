package com.example.equitablynourished;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity; //import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;
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
import android.widget.Toast;
import com.example.equitablynourished.ourclasses.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Static String to hold email value when sending data
    public static final String EXTRA_TEXT = "com.example.equitablynourished.EXTRA_TEXT";

    // Creating global variables needed for Login Page
    private TextView register;
    private EditText email, password;
    private Button login;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override // Starter Code
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checks to see if "Register" Button is Pressed
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener((View.OnClickListener) this);

        // Checks to see if Login Button is Pressed
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        // Initializes email, passsword, and progressBar for future use
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Sets up Authentication to Firebase
        mAuth = FirebaseAuth.getInstance();
    }

    @Override // Runs is any button is pressed
    public void onClick(View v) {
        switch (v.getId()){
            // Logic for Register Button
            case R.id.register:
                // Takes User to Registration Page
                startActivity(new Intent(this, RegisterUser.class));
                break;
            case R.id.login:
                userLogin();
                break;
        }
    }

    private void userLogin() {

        // Converts user input to Strings to store in variables
        final String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        // Checks to see if email field is empty
        if (emailText.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        // Checks to see if the email is valid (Imported library to check this for us)
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            password.setError("Enter valid email");
            password.requestFocus();
            return;
        }

        // Checks to see if password field is empty
        if (passwordText.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        // Checks to see if password is at least 6 characters
        if (password.length() < 6){
            password.setError("Minimum password length is 6 characters");
            password.requestFocus();
            return;
        }

        //Checks to see if user exists within database
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){ // If username and password match database -> User sent to main page
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    intent.putExtra(EXTRA_TEXT, emailText);
                    startActivity(intent);
                }else{ // If username and password do not match database -> User prompted to login again
                    Toast.makeText(MainActivity.this, "Failed to login. Please try again.", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
