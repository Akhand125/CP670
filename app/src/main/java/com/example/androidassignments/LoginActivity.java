package com.example.androidassignments;

import static com.example.androidassignments.R.id.editText;
import static com.example.androidassignments.R.id.editText2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button button3;
    private SharedPreferences sharedPreferences;
    private static final String Tag = "LoginActivity";
    private void print(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Tag", "This is an OnCreate method.");
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String DefaultEmail = "email@domain.com";
        Log.i("LoginActivity", "1");
        String savedEmail = sharedPreferences.getString("DefaultEmail", DefaultEmail);
        EditText editTextEmail = findViewById(R.id.editText);
        Log.i("LoginActivity", "2");
        editTextEmail.setText(savedEmail);
        Log.i("LoginActivity", "3");


        Log.i("LoginActivity", "end of oncreate");


    }

    public void Loginact(View v) {
        Log.i("LoginActivity", "inside lpogin");
        // Get the text from the emailEditText field
        EditText editTextEmaili = findViewById(R.id.editText);
        String email = editTextEmaili.getText().toString();
        EditText editTextPassword = findViewById(R.id.editText2);
        String password = editTextPassword.getText().toString();

        // Store the email in SharedPreferences

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            Log.i("LoginActivity", "inside IF");
        }

        else if (!email.matches(emailPattern)) {

            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            Log.i("LoginActivity", "inside 2IF");

        }
        else {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("DefaultEmail",email);
            editor.apply();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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