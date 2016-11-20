package com.example.yosuawitantra.cseshacknight;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mainApplication extends Application {
    private DatabaseReference database;
    private DataSnapshot currentSnapshot;

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance().getReference("https://popping-torch-2292.firebaseio.com/");
    }

    public void sendData(String type, Object item) {
        DatabaseReference itemReference = database.child(type);
        itemReference.setValue(item);
    }

    public void getData() {
        database.addValueEventListener( new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    currentSnapshot = dataSnapshot;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            }
        );
    }
}
