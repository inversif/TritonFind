package com.example.yosuawitantra.cseshacknight;

/**
 * Created by dianlin on 11/20/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
public class confirm_success extends AppCompatActivity {
    Button ok;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.found);

        ok = (Button) findViewById(R.id.okButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplication(), MainActivity.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
            }
        });


    }
}
