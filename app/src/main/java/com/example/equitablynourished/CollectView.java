package com.example.equitablynourished;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CollectView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_view);
        //get data and change the address label


        ValueEventListener Single = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = "";
                // Get Post object and use the values to update the UI
                data = dataSnapshot.getValue(String.class);
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError);
            }
        };
        FirebaseDatabase.getInstance().getReference("message").addListenerForSingleValueEvent(Single);
        TextView address = (TextView) findViewById(R.id.textView5);
        address.setText("");
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