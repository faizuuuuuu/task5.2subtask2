package com.example.itube;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle for_this_bundle) {
        super.onCreate(for_this_bundle);


        Intent intent_for = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent_for);
        finish();
    }
}
