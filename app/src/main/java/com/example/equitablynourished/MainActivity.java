package com.example.equitablynourished;


import androidx.appcompat.app.AppCompatActivity; //import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private TextView databasetest;

    @Override // Starter Code
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checks to see if "Register" Button is Pressed
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener((View.OnClickListener) this);

        databasetest = (TextView) findViewById(R.id.databasetest);
        databasetest.setOnClickListener((View.OnClickListener) this);
    }

    @Override // Runs is any button is pressed
    public void onClick(View v) {
        switch (v.getId()){
            // Logic for Register Button
            case R.id.register:
                // Takes User to Registration Page
                startActivity(new Intent(this, RegisterUser.class));
                break;
            case R.id.databasetest:
                //runs the databasetest function if the button is pressed
                Food food = new Food(145, "ASUCD Pantry", "Memorial Union, 1 Shields Ave #154, Davis, CA 956161525 State St, Santa Barbara, CA 93101");
                PopulateFoodBankDataBase test = new PopulateFoodBankDataBase();
                test.basicReadWrite(food);
                break;
        }
    }
}
