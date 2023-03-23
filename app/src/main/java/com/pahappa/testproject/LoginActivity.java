package com.pahappa.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
        private EditText mUsernameEditText;
        private EditText mPasswordEditText;
        private MaterialButton mLoginButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            mUsernameEditText = findViewById(R.id.username);
            mPasswordEditText = findViewById(R.id.password);
            mLoginButton = findViewById(R.id.signInbtn);


            TextView switchToSecondActivity = (TextView) findViewById(R.id.signOpt);
            switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchActivities();
                }
            });

            mLoginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle sign-in request
                    String username = mUsernameEditText.getText().toString();
                    String password = mPasswordEditText.getText().toString();

                    URL url = null;
                    HttpURLConnection conn = null;

                    try {
                        url = new URL("https://172.105.109.154:8080/pcg/api/v1/Users/LoginUser");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setRequestProperty("Content-Type", "application/json");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    String jsonInputString = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
                    try(OutputStream os = conn.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try(BufferedReader br = new BufferedReader(
                            new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        if(response.toString().equals("valid")){
                            // Login successful
                            Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                            // Navigate to the next screen
                            switchHomeActivity();
                        } else {
                            // Display error message to user
                            Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
        }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchHomeActivity() {
        Intent switchActivityIntent = new Intent(this, HomeActivity.class);
        switchActivityIntent.putExtra("username",String.valueOf(mUsernameEditText.getText()));
        startActivity(switchActivityIntent);
    }

}
