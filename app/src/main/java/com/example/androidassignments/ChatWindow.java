package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        ListView chatView = findViewById(R.id.chat_view);
        Button sendButton = findViewById(R.id.send_button);
        EditText chatDialog = findViewById(R.id.chat_dialog);
        ArrayList<String> messages = new ArrayList<>();
        ChatAdapter adapter = new ChatAdapter(this, messages);

        chatView.setAdapter(adapter);

        sendButton.setOnClickListener(v -> {
            String text = chatDialog.getText().toString();
            if(text.length() > 0){
                adapter.add(text);
                chatDialog.setText("");
            }
        });
    }
}
