package com.pahappa.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    String inputUserName;
    String inputEmail;
    String inputPassWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = (EditText) findViewById(R.id.username);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        TextView signOption = (TextView) findViewById(R.id.signOpt);

        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbtn);

         inputUserName = String.valueOf(username.getText());
         inputEmail =  String.valueOf(email.getText());
         inputPassWord =  String.valueOf(password.getText());

        TextView switchToSecondActivity = (TextView) findViewById(R.id.signOpt);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });


        regbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                          Toast.makeText(MainActivity.this, "Registering done "+String.valueOf(username.getText()), Toast.LENGTH_SHORT).show();
                                      }
                                  }
        );

    }


    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, LoginActivity.class);
        switchActivityIntent.putExtra("username", inputUserName);
        startActivity(switchActivityIntent);
    }

    private void reg(){

    }
}