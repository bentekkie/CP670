package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText loginName;
    private final String LOG_KEY = getClass().getSimpleName();
    private static final String LOGIN_NAME_KEY = "LoginActivity.LOGIN_NAME_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginName = findViewById(R.id.login_name_edit_text);
        Button loginButton = findViewById(R.id.login_button);
        String email = getPreferences(MODE_PRIVATE).getString(LOGIN_NAME_KEY,"email@domain.com");
        loginName.setText(email);
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_KEY, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_KEY, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_KEY, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_KEY, "In onStop()");
        if(loginName != null){
            String loginNameString = loginName.getText().toString();
            getPreferences(MODE_PRIVATE).edit().putString(LOGIN_NAME_KEY, loginNameString).apply();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_KEY, "In onDestroy()");
    }
}
