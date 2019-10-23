package com.example.androidassignments;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TestToolbar extends AppCompatActivity {
    private final String LOG_KEY = getClass().getSimpleName();

    String message = "You selected item 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, R.string.fab_clicked_message, Snackbar.LENGTH_LONG).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(LOG_KEY, "In onCreateOptionsMenu()");
        getMenuInflater().inflate(R.menu.toolbar_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_one: {
                Snackbar.make(findViewById(R.id.root_for_snackbar), message, Snackbar.LENGTH_LONG).show();
                break;
            }
            case R.id.action_two: {
                new AlertDialog.Builder(this)
                        .setTitle(R.string.go_back_title)
                        .setPositiveButton(R.string.yes, (d, i) -> finish())
                        .setNegativeButton(R.string.no, (d, i) -> d.dismiss())
                        .create()
                        .show();
                break;
            }
            case R.id.action_three: {
                new AlertDialog.Builder(this)
                        .setView(getLayoutInflater().inflate(R.layout.dialog_layout, null))
                        .setPositiveButton(R.string.yes, (d, i) -> {
                            TextView tv = ((AlertDialog) d).findViewById(R.id.message);
                            message = tv.getText().toString();
                        })
                        .setNegativeButton(R.string.no, (d, i) -> d.dismiss())
                        .create()
                        .show();
                break;
            }
            case R.id.action_about: {
                Toast.makeText(this, R.string.version_text, Toast.LENGTH_LONG).show();
                break;
            }
        }
        return true;

    }

}
