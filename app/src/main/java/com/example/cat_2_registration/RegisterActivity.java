package com.example.cat_2_registration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class RegisterActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
    }

    // Method to handle registration
    public void registerUser(View view) {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        // Check if email and password fields are not empty
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create an instance of the DatabaseHelper
        DBHelper dbHelper = new DBHelper(this);

        // Check if user already exists
        if (dbHelper.checkUserCredentials(email, password)) {
            Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
        } else {
            // Add new user to the database
            dbHelper.registerUser(email, password);
            Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();

            // Optionally, redirect to login screen after successful registration
            // Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            // startActivity(intent);
            // finish();
        }
    }
}
