package com.example.equitablynourished;


import androidx.appcompat.app.AppCompatActivity; //import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;

    @Override // Starter Code
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checks to see if "Register" Button is Pressed
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener((View.OnClickListener) this);
    }

    @Override // Runs is any button is pressed
    public void onClick(View v) {
        switch (v.getId()){
            // Logic for Register Button
            case R.id.register:
                // Takes User to Registration Page
                startActivity(new Intent(this, RegisterUser.class));
                break;
        }
    }
}
