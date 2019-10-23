package com.example.androidassignments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<String> {
    public ChatAdapter(@NonNull Context context, @NonNull List<String> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String message = getItem(position);

        if (position % 2 == 0) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.chat_row_incoming, parent, false);
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.chat_row_outgoing, parent, false);
        }

        TextView messageView = convertView.findViewById(R.id.message_text);
        messageView.setText(message);
        return convertView;
    }
}
