package com.example.yosuawitantra.cseshacknight;

import android.app.Application;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mainApplication extends Application {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DataSnapshot currentSnapshot;
    DatabaseReference reference = database.getReference("https://popping-torch-2292.firebaseio.com/");

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void sendData(String type, Object item) {
        DatabaseReference itemReference = reference.child(type);
        itemReference.setValue(item);
    }

    public void getData() {
        reference.addValueEventListener( new ValueEventListener() {
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
