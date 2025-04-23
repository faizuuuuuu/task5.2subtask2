package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    EditText val_url_for;
    Button btn_play_for, btn_add_for, btn_playlist_for;

    @Override
    protected void onCreate(Bundle for_this_Val) {
        super.onCreate(for_this_Val);
        setContentView(R.layout.activity_home);

        val_url_for = findViewById(R.id.editUrl);
        btn_play_for = findViewById(R.id.btnPlay);
        btn_add_for = findViewById(R.id.btnAddPlaylist);
        btn_playlist_for = findViewById(R.id.btnPlaylist);

        btn_play_for.setOnClickListener(v -> {
            String link_for = val_url_for.getText().toString().trim();
            if (link_for.isEmpty()) {
                Toast.makeText(this, "Please enter a YouTube URL", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent_for = new Intent(HomeActivity.this, VideoPlayerActivity.class);
                intent_for.putExtra("youtube_url", link_for);
                startActivity(intent_for);
            }
        });

        btn_add_for.setOnClickListener(v -> {
            String url_for = val_url_for.getText().toString().trim();
            if (url_for.isEmpty()) {
                Toast.makeText(this, "Enter a valid URL to add to playlist", Toast.LENGTH_SHORT).show();
            } else {
                DatabaseHelper helper_for = new DatabaseHelper(this);
                helper_for.addToPlaylist(url_for);
                Toast.makeText(this, "Added to playlist!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_playlist_for.setOnClickListener(v -> {
            Intent intent_to_list = new Intent(HomeActivity.this, PlaylistActivity.class);
            startActivity(intent_to_list);
        });
    }
}
