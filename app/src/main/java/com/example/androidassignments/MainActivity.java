package com.example.androidassignments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_LIST_ITEMS = 10;
    private Button button;
    private static final String Tag = "MainActivity";
    private void print(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Tag", "This is an OnCreate method.");
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListItemsActivity();
            }
        });
    }
    public void openListItemsActivity(){
        Intent intent = new Intent(this,ListItemsActivity.class);
        startActivityForResult(intent, REQUEST_CODE_LIST_ITEMS);
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_LIST_ITEMS) {
            if (resultCode == RESULT_OK) {
                String requesteddata = data.getStringExtra("Response");
                Toast.makeText(this,"ListItemsActivity passed" + requesteddata, Toast.LENGTH_SHORT).show();
                Log.i("MainActivity", "Returned to MainActivity.onActivityResult");
            } else if (resultCode == RESULT_CANCELED) {

            }
        }
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