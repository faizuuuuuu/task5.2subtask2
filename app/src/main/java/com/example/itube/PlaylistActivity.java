package com.example.itube;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

    RecyclerView recycler_for;
    PlaylistAdapter adapter_for;

    @Override
    protected void onCreate(Bundle val_for_bundle) {
        super.onCreate(val_for_bundle);
        setContentView(R.layout.activity_playlist);

        recycler_for = findViewById(R.id.recyclerPlaylist);
        recycler_for.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper db_for = new DatabaseHelper(this);
        List<String> playlist_for = db_for.getPlaylist();

        adapter_for = new PlaylistAdapter(this, playlist_for, url_for -> {
            Intent intent = new Intent(this, VideoPlayerActivity.class);
            intent.putExtra("youtube_url", url_for);
            startActivity(intent);
        });

        recycler_for.setAdapter(adapter_for);
    }
}
