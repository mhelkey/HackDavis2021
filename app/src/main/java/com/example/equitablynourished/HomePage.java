package com.example.equitablynourished;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    // method to be called when the 'donate button' is clicked.
    public void openDonateView(View view){
        Intent intent = new Intent(this, DonateView.class);
        startActivity(intent);
    }

    //method to be called when the 'collect' button is clicked.
    public void openCollectView(View view){
        Intent intent = new Intent(this, CollectView.class);
        startActivity(intent);
    }

    //method to be called when the 'history' button is clicked.
    public void openHistoryView(View view){
        // TO BE IMPLEMENTED LATER
    }

    //method to be called when the 'Account settings' button is clicked
    public void openAccountSettings(View view){

    }

}