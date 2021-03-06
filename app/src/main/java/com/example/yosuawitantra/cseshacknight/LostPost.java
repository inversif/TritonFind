package com.example.yosuawitantra.cseshacknight;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Yosua Witantra on 11/20/2016.
 */

public class LostPost extends AppCompatActivity implements View.OnClickListener {

    static int LOST_RESULT_LOAD_IMAGE = 1;
    ImageButton Find;
    ImageButton Home;
    ImageButton Lost;
    Button Post;
    ImageView imageView;
    ImageButton ViewList;

    @Override
    protected void onStart() { super.onStart(); }

    public String getLocation(){
        String location = ((EditText) findViewById(R.id.loc)).getText().toString();
        return location;
    }

    public String getDateandTime(){
        String chronology = ((EditText) findViewById(R.id.time)).getText().toString();
        return chronology;
    }

    public String getDescription(){
        String description = ((EditText) findViewById(R.id.description)).getText().toString();
        return description;
    }

    public void getContact(){
        // Should GET email from Firebase, perhaps?
        String email = ((EditText) findViewById(R.id.contactme)).getText().toString();
    }

    public Item postPost() {
        Item i = new Item(getDescription(), getLocation(), "", getDateandTime(), "", imageView);
        return i;
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
        Find = (ImageButton) findViewById(R.id.find);
        Home = (ImageButton) findViewById(R.id.home);
        Lost = (ImageButton) findViewById(R.id.lost);
        Post = (Button) findViewById(R.id.post);
        ViewList = (ImageButton) findViewById(R.id.ViewList);

        ViewList .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplication(), FoundList.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
            }
        });

        Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplication(), confirm_success.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
            }
        });

        Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplication(), LostPost.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
            }
        });
        Find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplication(), FoundPost.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplication(), MainActivity.class);
                mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);
            }
        });
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

            imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }
}
