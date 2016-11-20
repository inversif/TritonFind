package com.example.yosuawitantra.cseshacknight;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Yosua Witantra on 11/20/2016.
 */

public class LostPost extends AppCompatActivity implements View.OnClickListener {

    static int LOST_RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onStart() { super.onStart(); }

    public void getLocation(){
        String location = ((EditText) findViewById(R.id.loc)).getText().toString();
    }

    public void getDateandTime(){
        String chronology = ((EditText) findViewById(R.id.time)).getText().toString();
    }

    public void getDescription(){
        String description = ((EditText) findViewById(R.id.description)).getText().toString();
    }

    public void getContact(){
        // Should GET email from Firebase, perhaps?
        String email = ((EditText) findViewById(R.id.contactme)).getText().toString();
    }

    public void postPost(){
        // More Firebase stuff
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post:
                postPost();
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);

        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, LOST_RESULT_LOAD_IMAGE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOST_RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }
}
