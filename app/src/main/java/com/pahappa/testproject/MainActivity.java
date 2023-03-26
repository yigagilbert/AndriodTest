package com.pahappa.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.pahappa.testproject.data.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    String inputUserName;
    String inputEmail;
    String inputPassWord1;
    String inputPassWord2;

    //create an object to get user data.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = (EditText) findViewById(R.id.username);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password1 = (EditText) findViewById(R.id.password);
        EditText password2 = (EditText) findViewById(R.id.repassword);
        TextView switchToSecondActivity = (TextView) findViewById(R.id.signOpt);
        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbtn);


        //To move to the sign in screen.
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                          //get input
                                          inputUserName = String.valueOf(username.getText());
                                          inputEmail =  String.valueOf(email.getText());
                                          inputPassWord1 =  String.valueOf(password1.getText());
                                          inputPassWord2 =  String.valueOf(password2.getText());


                                          //set user data to user model
                                          User.setUsername(inputUserName);
                                          User.setEmail(inputEmail);
                                          User.setPassword(inputPassWord1);
                                          switchActivities();
                                          Toast.makeText(MainActivity.this, "Registering done "+String.valueOf(username.getText()), Toast.LENGTH_SHORT).show();
                                      }
                                  }
        );

    }


    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(switchActivityIntent);
    }

}
