package com.example.androidassignments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
            startActivityForResult(intent,10);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && data != null){
            Log.i(this.getClass().getSimpleName(), "Returned to StartActivity.onActivityResult");
            String messagePassed = data.getStringExtra("Response");
            Toast toast = Toast.makeText(this , messagePassed, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
