package com.example.yosuawitantra.cseshacknight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
/**
 * Created by dianlin on 11/20/16.
 */

public class FoundList extends AppCompatActivity {
    Button LostHeader;
    ImageButton Find;
    ImageButton Home;
    ImageButton Lost;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.found);
        LostHeader = (Button) findViewById(R.id.lost);
        Find = (ImageButton) findViewById(R.id.find);
        Home = (ImageButton) findViewById(R.id.home);
        Lost = (ImageButton) findViewById(R.id.lost);

        LostHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoundList.this, LostList.class));
            }
        });
        Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoundList.this, LostPost.class));
            }
        });
        Find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoundList.this, FoundPost.class));
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoundList.this, MainActivity.class));
            }
        });

    }

}


