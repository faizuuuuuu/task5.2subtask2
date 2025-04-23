package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText val_fullname_for, val_username_for, val_password_for, val_confirm_for;
    Button btn_create_for;

    @Override
    protected void onCreate(Bundle for_this_savedInstance) {
        super.onCreate(for_this_savedInstance);
        setContentView(R.layout.activity_signup);

        val_fullname_for = findViewById(R.id.editFullname);
        val_username_for = findViewById(R.id.editUsername);
        val_password_for = findViewById(R.id.editPassword);
        val_confirm_for = findViewById(R.id.editConfirmPassword);
        btn_create_for = findViewById(R.id.btnCreateAccount);

        btn_create_for.setOnClickListener(v -> {
            String name_for = val_fullname_for.getText().toString().trim();
            String username_for = val_username_for.getText().toString().trim();
            String password_for = val_password_for.getText().toString().trim();
            String confirm_for = val_confirm_for.getText().toString().trim();

            if (name_for.isEmpty() || username_for.isEmpty() || password_for.isEmpty() || confirm_for.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password_for.equals(confirm_for)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }


            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            finish();
        });
    }
}
