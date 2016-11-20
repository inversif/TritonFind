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

public class LostList extends AppCompatActivity {
    Button FoundHeader;
    ImageButton Find;
    ImageButton Home;
    ImageButton Lost;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lost);

        FoundHeader = (Button)findViewById(R.id.FoundHeader);
        Find = (ImageButton)findViewById(R.id.find);
        Home = (ImageButton)findViewById(R.id.home);
        Lost = (ImageButton)findViewById(R.id.lost);


        FoundHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LostList.this, FoundList.class));
            }
        });
        Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LostList.this, LostPost.class));
            }
        });
        Find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LostList.this, FoundPost.class));
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LostList.this, MainActivity.class));
            }
        });

    }
}
