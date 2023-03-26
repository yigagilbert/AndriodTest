package com.pahappa.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.pahappa.testproject.data.User;


public class LoginActivity extends AppCompatActivity {
        private EditText mUsernameEditText;
        private EditText mPasswordEditText;
        private MaterialButton mLoginButton;
        User userObj = null;
        String myUser;
    String loginUsername;
    String loginPassword;
    String userUsername;
    String userPassword;

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
                    loginUsername = mUsernameEditText.getText().toString();
                    loginPassword = mPasswordEditText.getText().toString();
                    userUsername =User.getUsername();
                    userPassword = User.getPassword();

                    System.out.println("User Name: "+userUsername);

                    // compare login details.
                    if (loginUsername.equals(userUsername) && loginPassword.equals(userPassword)) {
                        // Login successful
                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        // Navigate to the next screen
                        switchHomeActivity();
                    }else {
                        //show wrong details entered toast.
                        Toast.makeText(LoginActivity.this, "Wrong details entered or null!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchHomeActivity() {
            Intent switchActivityIntent = new Intent(this, DashBroadActivity.class);
            switchActivityIntent.putExtra("username",String.valueOf(mUsernameEditText.getText()));
            startActivity(switchActivityIntent);
    }


}
