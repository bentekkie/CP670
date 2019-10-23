package com.example.androidassignments;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private final String LOG_KEY = getClass().getSimpleName();
    static final String RESPONSE_DATA_KEY = ListItemsActivity.class.getName()+".RESPONSE";
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        imageButton = findViewById(R.id.imageButton);
        Switch switchWidget = findViewById(R.id.switch1);
        CheckBox checkBox = findViewById(R.id.checkBox);
        imageButton.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        });
        switchWidget.setOnCheckedChangeListener((bv,checked) -> {
            CharSequence text = checked? "Switch is On" : "Switch is Off";
            int duration = checked ? Toast.LENGTH_SHORT :  Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(this , text, duration);
            toast.show();
        });
        checkBox.setOnCheckedChangeListener((cb, checked) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message)
                    .setTitle(R.string.dialog_title)
                    .setPositiveButton(R.string.yes, (dialog, id) -> {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra(getClass().getName()+".RESPONSE", getResources().getString(R.string.response_message));
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();

                    })
                    .setNegativeButton(R.string.no, (dialog, id) -> {})
                    .show();

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_KEY, "In onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if(extras != null) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageButton.setImageBitmap(imageBitmap);
            }
        }
    }
}
