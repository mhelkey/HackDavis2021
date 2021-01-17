package com.example.equitablynourished;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class DonateView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_view);
        //get data and change the address label
        TextView address = (TextView) findViewById(R.id.textView5);
        //address.setText(FirebaseDatabase.getInstance().getReference("message").addListenerForSingleValueEvent());
    }

    // method to call when the `correct` address button is pressed
    public void onAddressConfirmation(View view){

    }
    //method to call when teh `wrong` address button is pressed
    public void onAddressDenied(View view){
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);

    }

}