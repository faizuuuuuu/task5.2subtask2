package com.example.itube;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {

    WebView web_for_player;

    @Override
    protected void onCreate(Bundle for_this_bundle) {
        super.onCreate(for_this_bundle);
        setContentView(R.layout.activity_video_player);

        web_for_player = findViewById(R.id.webPlayer);

        String val_for_url = getIntent().getStringExtra("youtube_url");

        if (val_for_url != null && !val_for_url.isEmpty()) {
            loadYouTubeVideo(val_for_url);
        }
    }

    private void loadYouTubeVideo(String url_for) {
        // Format the URL to embed if needed
        String embed_url = url_for.contains("watch?v=")
                ? url_for.replace("watch?v=", "embed/")
                : url_for;

        String html_for_video = "<html><body style='margin:0;padding:0;'>" +
                "<iframe width=\"100%\" height=\"100%\" src=\"" + embed_url +
                "\" frameborder=\"0\" allowfullscreen></iframe>" +
                "</body></html>";

        WebSettings setting_for_web = web_for_player.getSettings();
        setting_for_web.setJavaScriptEnabled(true);

        web_for_player.setWebViewClient(new WebViewClient());
        web_for_player.loadData(html_for_video, "text/html", "utf-8");
    }
}
