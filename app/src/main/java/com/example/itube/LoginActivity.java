package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText val_username_for, val_password_for;
    Button btn_login_for, btn_signup_for;

    @Override
    protected void onCreate(Bundle for_this_savedInstance) {
        super.onCreate(for_this_savedInstance);
        setContentView(R.layout.activity_login);

        val_username_for = findViewById(R.id.editUsername);
        val_password_for = findViewById(R.id.editPassword);
        btn_login_for = findViewById(R.id.btnLogin);
        btn_signup_for = findViewById(R.id.btnSignup);

        btn_login_for.setOnClickListener(v -> {
            String username_for = val_username_for.getText().toString().trim();
            String password_for = val_password_for.getText().toString().trim();

            // For now, just allow any non-empty login
            if (!username_for.isEmpty() && !password_for.isEmpty()) {
                Intent intent_to_home = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent_to_home);
            } else {
                Toast.makeText(LoginActivity.this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
            }
        });

        btn_signup_for.setOnClickListener(v -> {
            Intent intent_to_signup = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent_to_signup);
        });
    }
}
