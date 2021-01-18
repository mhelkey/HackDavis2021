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

import java.util.ArrayList;

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

                ArrayList<String> list = new ArrayList<String>();
                list.add("ASUCD Pantry Num: 145. Barcode: Memorial Union, 1 Shields Ave #154, Davis, CA 956161525 State St, Santa Barbara, CA 93101");
                list.add("Food Bank Num: 123456. Barcode: Earth");
                list.add("Santa Barbara Food Bank Num: 1212. Barcode: 1525 State St, Santa Barbara, CA 93101");
                list.add("Yolo Food Bank Num: 12. Barcode: 233 Harter Ave, Woodland, CA 95776");

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError);
            }
        };
        FirebaseDatabase.getInstance().getReference("message").addListenerForSingleValueEvent(Single);
        TextView address = (TextView) findViewById(R.id.textView5);
        //address.setText("");
    }

    // method to call when the `correct` address button is pressed
    public void onAddressConfirmation(View view){
        Intent intent = new Intent(this, CollectorMapView.class);
        startActivity(intent);
    }
    //method to call when teh `wrong` address button is pressed
    public void onAddressDenied(View view){
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);

    }
}