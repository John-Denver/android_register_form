package com.example.cat_2_registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Declare the EditText and Button views
    EditText edtLoginEmail, edtLoginPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Set the layout for this activity

        // Initialize the views
        edtLoginEmail = findViewById(R.id.edtLoginEmail);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Set up the OnClickListener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered by the user
                String email = edtLoginEmail.getText().toString();
                String password = edtLoginPassword.getText().toString();

                // Basic validation check (in real scenarios, validate email format, password, etc.)
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Here you can validate the user credentials with SQLite or a server
                    if (validateCredentials(email, password)) {
                        // If credentials are valid, proceed to the Home Activity
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();  // Finish the LoginActivity so the user can't navigate back to it
                    } else {
                        // If invalid credentials, show a message
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // Method to simulate credential validation
    private boolean validateCredentials(String email, String password) {
        // For now, we are using hardcoded credentials.
        // In a real app, you would query the database to validate the user's credentials.
        return email.equals("user@example.com") && password.equals("password123");
    }
}
