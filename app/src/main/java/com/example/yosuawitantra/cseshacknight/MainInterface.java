package com.example.yosuawitantra.cseshacknight;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import static android.R.id.toggle;

/**
 * Created by Yosua Witantra on 11/20/2016.
 */

public class MainInterface extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        /* setup access to the main application class */
        ToggleButton toggling = ((ToggleButton)findViewById(R.id.togglebutton));
        // updatePartnerLocations();
        toggling.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean on  =((ToggleButton) v).isChecked();
                if(on) { found_header(); }
                else { lost_header(); }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void found_header(){
        setContentView(R.layout.found);
        Item[] array = new Item[5];
        array = getData(Found);

        if(array[0] == null) return;
        ((TextView) findViewById(R.id.itemOneT)).setText(array[0].getName());
        //((ImageView) findViewById(R.id.itemOneP);
        ImageView image1 = (ImageView) findViewById(R.id.itemOneI);
        image1.setImageResource(R.drawable.drop_down);

        if(array[1] == null) return;
        ((TextView) findViewById(R.id.itemTwoT)).setText(array[1].getName());
        //((ImageView) findViewById(R.id.itemTwoP);
        ImageView image2 = (ImageView) findViewById(R.id.itemTwoI);
        image2.setImageResource(R.drawable.drop_down);

        if(array[2] == null) return;
        ((TextView) findViewById(R.id.itemThreeT)).setText(array[2].getName());
        //((ImageView) findViewById(R.id.itemThreeP);
        ImageView image3 = (ImageView) findViewById(R.id.itemThreeI);
        image3.setImageResource(R.drawable.drop_down);

        if(array[3] == null) return;
        ((TextView) findViewById(R.id.itemThreeT)).setText(array[3].getName());
        //((ImageView) findViewById(R.id.itemThreeP);
        ImageView image4 = (ImageView) findViewById(R.id.itemFourI);
        image4.setImageResource(R.drawable.drop_down);

        if(array[4] == null) return;
        ((TextView) findViewById(R.id.itemThreeT)).setText(array[4].getName());
        //((ImageView) findViewById(R.id.itemThreeP);
        ImageView image5 = (ImageView) findViewById(R.id.itemFiveI);
        image5.setImageResource(R.drawable.drop_down);
    }

    public void lost_header(){
        setContentView(R.layout.lost);
        Item[] array = new Item[5];
        array = getData(Lost);

        if(array[0] == null) return;
        ((TextView) findViewById(R.id.itemOneTL)).setText(array[0].getName());
        //((ImageView) findViewById(R.id.itemOneIL);
        ImageView image1 = (ImageView) findViewById(R.id.itemOneBL);
        image1.setImageResource(R.drawable.drop_down);

        if(array[1] == null) return;
        ((TextView) findViewById(R.id.itemTwoTL)).setText(array[1].getName());
        //((ImageView) findViewById(R.id.itemTwoIL);
        ImageView image2 = (ImageView) findViewById(R.id.itemTwoBL);
        image2.setImageResource(R.drawable.drop_down);

        if(array[2] == null) return;
        ((TextView) findViewById(R.id.itemThreeTL)).setText(array[2].getName());
        //((ImageView) findViewById(R.id.itemThreeIL);
        ImageView image3 = (ImageView) findViewById(R.id.itemThreeBL);
        image3.setImageResource(R.drawable.drop_down);

        if(array[3] == null) return;
        ((TextView) findViewById(R.id.itemFourTL)).setText(array[3].getName());
        //((ImageView) findViewById(R.id.itemFourIL);
        ImageView image4 = (ImageView) findViewById(R.id.itemFourBL);
        image4.setImageResource(R.drawable.drop_down);

        if(array[4] == null) return;
        ((TextView) findViewById(R.id.itemFiveTL)).setText(array[4].getName());
        //((ImageView) findViewById(R.id.itemFiveIL);
        ImageView image5 = (ImageView) findViewById(R.id.itemFiveBL);
        image5.setImageResource(R.drawable.drop_down);
    }

    @Override
    public void onClick(View view) {

    }
}
