package com.example.androidassignments;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {

    public Button button2;
    private ImageButton imageButton;
    private Switch switch1;

    private CheckBox checkBox;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private String imagePath = null;

    private void print(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    private static final String Tag = "ListItemsActivity";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Tag", "This is an OnCreate method.");
        setContentView(R.layout.activity_list_items);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");



                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                
            }
        });

        switch1 = findViewById(R.id.switch1);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    showToast("Switch is On");
                } else {
                    showToast("Switch is Off");
                }
            }
        });

        // Find the CheckBox by its ID
        checkBox = findViewById(R.id.checkBox2);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    showFinishDialog();
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            if (extras != null) {

                Bitmap imageBitmap = (Bitmap) extras.get("data");


                imageButton.setImageBitmap(imageBitmap);
            }
        }
    }

    private void showFinishDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to finish the activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Intent resultIntent = new Intent();
                      resultIntent.putExtra("Response", "My information to share");
                      setResult(Activity.RESULT_OK,resultIntent);

                        finish();
                        Log.i("ListItemsActivity","onfinish was called");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Uncheck the CheckBox if the user selects "No"
                        checkBox.setChecked(false);
                    }
                })
                .create()
                .show();
    }

    private void showToast(String message) {
        int duration = switch1.isChecked() ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG;
        Toast.makeText(this, message, duration).show();
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Tag", "This is an OnResume method.");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Tag", "This is an OnStart method.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Tag", "This is an OnPause method.");
    }

    protected  void onStop(){
        super.onStop();
        Log.i("Tag","This is an OnStop method");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("Tag","This is an OnDestroy method");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Tag","This is an OnSaveInstanceState method");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("Tag","This is an OnRestoreInstanceState method");
    }
}