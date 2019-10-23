package com.example.androidassignments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    private final String LOG_KEY = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button button = findViewById(R.id.button);
        Button startChatButton = findViewById(R.id.start_chat);
        Button toolBarButton = findViewById(R.id.start_test_toolbar);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListItemsActivity.class);
            startActivityForResult(intent,10);
        });
        startChatButton.setOnClickListener(v -> {
            Log.i(LOG_KEY, "User clicked Start Chat");
            Intent intent = new Intent(this, ChatWindow.class);
            startActivity(intent);
        });
        toolBarButton.setOnClickListener(v -> {
            Log.i(LOG_KEY, "User clicked Test Toolbar");
            Intent intent = new Intent(this, TestToolbar.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_KEY, "In onCreate()");
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_KEY, "In onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && data != null){
            Log.i(LOG_KEY, "Returned to StartActivity.onActivityResult");
            if(data.hasExtra(ListItemsActivity.RESPONSE_DATA_KEY)) {
                String messagePassed = data.getStringExtra(ListItemsActivity.RESPONSE_DATA_KEY);
                Toast toast = Toast.makeText(this, messagePassed, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
