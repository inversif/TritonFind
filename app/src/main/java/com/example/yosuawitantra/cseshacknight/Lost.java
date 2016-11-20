package com.example.yosuawitantra.cseshacknight;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Yosua Witantra on 11/20/2016.
 */

public class Lost extends AppCompatActivity implements View.OnClickListener {

    static int LOST_RESULT_LOAD_IMAGE = 22273;

    @Override
    protected void onStart() { super.onStart(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
            case R.id.loadPicture:
                uploadPhotos();
                break;
        }
    }

    // SOURCE: http://viralpatel.net/blogs/pick-image-from-galary-android-app/
    public void uploadPhotos() {
        Intent upload = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(upload, LOST_RESULT_LOAD_IMAGE);
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

            // String picturePath contains the path of selected Image
        }

    }
}
