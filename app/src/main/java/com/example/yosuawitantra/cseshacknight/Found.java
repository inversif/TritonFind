package com.example.yosuawitantra.cseshacknight;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import static android.R.attr.button;

/**
 * Created by Yosua Witantra on 11/19/2016.
 */

public class Found extends AppCompatActivity implements View.OnClickListener {

    static final int FOUND_RESULT_LOAD_IMAGE = 9001;

    @Override
    protected void onStart() { super.onStart(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void createDescription() {
        String description = ((EditText) findViewById(R.id.description)).getText().toString();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.hold:
                if (checked)
                    // Do something??
                    break;
            case R.id.drop:
                if (checked)
                    // Do something??
                    break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLoadPicture:
                uploadPhotos();
                break;
            case R.id.post:
                postPost();
                break;
        }
    }

    public void postPost() {
        // Jose implement database plz
    }

    // SOURCE: http://viralpatel.net/blogs/pick-image-from-galary-android-app/
    public void uploadPhotos() {
        Intent upload = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(upload, FOUND_RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FOUND_RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
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