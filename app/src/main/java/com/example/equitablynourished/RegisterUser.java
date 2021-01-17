package com.example.equitablynourished;

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
import com.google.firebase.database.FirebaseDatabase;
import org.w3c.dom.Text;
import java.util.Objects;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    // Creating all Variables needed for Program (Global Variables)
    private Button register;
    private TextView title;
    private EditText email, fullname, number, address, password;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override // Starter Code
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        // Sets up Authentication to Firebase
        mAuth = FirebaseAuth.getInstance();

        // Checks to see if the title is pressed on
        title = (TextView) findViewById(R.id.title);
        title.setOnClickListener(this);

        // Checks to see if register button is pressed
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        // Retrieves data from App Text Fields into Global Variables
        email = (EditText) findViewById(R.id.email);
        fullname = (EditText) findViewById(R.id.fullname);
        number = (EditText) findViewById(R.id.number);
        address = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override // Code Runs is Register Button or Title are Pressed
    public void onClick(View view) {
        switch (view.getId()){
            // Runs is title is pressed
            case R.id.title:
                // Sends User back to Home Page
                startActivity(new Intent(this, MainActivity.class));
                break;
            // Runs if user clicks "register" button
            case R.id.register:
                // Runs registerUser() function -> Shown Below
                registerUser();
                break;
        }

    }

    // Runs if User Clicks "register" button
    private void registerUser() {

        // Stores all input fields in app as strings
        final String emailText = email.getText().toString().trim();
        final String fullnameText = fullname.getText().toString().trim();
        final String numberText = number.getText().toString().trim();
        final String addressText = address.getText().toString().trim();
        final String passwordText = password.getText().toString().trim();

        // Verifies that full name entry is not empty
        if (fullnameText.isEmpty()){
            fullname.setError("Full name is required");
            fullname.requestFocus();
            return;
        }

        // Verifies that email entry is not empty
        if (emailText.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        // Verifies that phone number entry is not empty
        if (numberText.isEmpty()){
            number.setError("Email is required");
            number.requestFocus();
            return;
        }

        // Verifies that address entry is not empty
        if (addressText.isEmpty()){
            address.setError("Email is required");
            address.requestFocus();
            return;
        }

        // Verifies that password entry is not empty
        if (passwordText.isEmpty()){
            password.setError("Email is required");
            password.requestFocus();
            return;
        }

        // Verifies that email entry is valid (Imported a library to do this for us)
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            email.setError("Enter valid email");
            email.requestFocus();
            return;
        }

        // // Verifies that password is at least 6 characters
        if(passwordText.length() < 6){
            password.setError("Minimum length is 6 characters");
            password.requestFocus();
            return;
        }

        // Attempts to add user to Database
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    // Stores all user data in a class object called "user" which I created
                    // This class object is sent to Database
                    User user = new User(emailText, fullnameText, numberText, addressText, passwordText);

                    FirebaseDatabase.getInstance().getReference("Users").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            // If user is successfully added to database -> sends user back to login page
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterUser.this, "User has been registered successfully", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                                goToMainPage(); // Sends user back to Login Page
                            }else{ // If user is not successfully added to database -> throws error and asks them to try again
                                Toast.makeText(RegisterUser.this, "Failed to register. Try again.", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }else{ // If user is not successfully added to database -> throws error and asks them to try again
                    Toast.makeText(RegisterUser.this, "Failed to register. Try again.", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    // Sends user to Login Page
    public void goToMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}