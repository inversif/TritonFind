package com.example.yosuawitantra.cseshacknight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

/**
 * Created by Yosua Witantra on 11/20/2016.
 */

public class MainApplication extends AppCompatActivity implements View.OnClickListener{
    Item list_of_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        /* setup access to the main application class */
        ((ToggleButton)findViewById(R.id.togglebutton).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId() ) {
            case R.id.togglebutton:
                break;
        }
    }
}
