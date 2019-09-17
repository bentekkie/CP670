package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText loginName = findViewById(R.id.login_name_edit_text);
        Button loginButton = findViewById(R.id.login_button);
        String email = getPreferences(MODE_PRIVATE).getString("email","email@domain.com");
        loginName.setText(email);
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, StartActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(this.getClass().getSimpleName(), "In onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(this.getClass().getSimpleName(), "In onCreate()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(this.getClass().getSimpleName(), "In onCreate()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(this.getClass().getSimpleName(), "In onCreate()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.getClass().getSimpleName(), "In onCreate()");
    }
}
