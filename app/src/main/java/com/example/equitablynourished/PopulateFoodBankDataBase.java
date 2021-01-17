package com.example.equitablynourished;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.example.equitablynourished.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class PopulateFoodBankDataBase extends AppCompatActivity {

    private static final String TAG = "PopulateFoodBankData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void basicReadWrite(Food food) {
        // [START write_message]
        // Write a message to the database
        //String name = dataSnapshot.child("Name").getValue(String.class);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("FoodBankData").child(food.returnitemname());
        //FirebaseDatabase.getInstance().getReference("Users").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(user).addOnCompleteListener(

//        Food food = new Food(12, "Yolo Food Bank", "233 Harter Ave, Woodland, CA 95776");
//        Food food1 = new Food(100, "Yolo Swag Food Bank", "233 Harter Ave, Woodland, CA 95776");


        myRef.setValue(food.printFood());
//        myRef.setValue(food1.printFood());
        // [END write_message]

        // [START read_message]
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        // [END read_message]
    }
}
