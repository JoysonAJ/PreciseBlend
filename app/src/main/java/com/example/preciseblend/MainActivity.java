package com.example.preciseblend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String use="User1";
    private String psw="1234";
    TextView username,password;
    Button login,googleLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.usn);
        password = findViewById(R.id.pas);

        login = findViewById(R.id.Login);
//        googleLogin = findViewById(R.id.GoogleLogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validCredntial(username.getText().toString(),password.getText().toString());
            }
        });
    }

    private void validCredntial(String userName, String userPassword) {
        if(userName.equals(use) && userPassword.equals(psw) ){
            Intent intent =new Intent(MainActivity.this,HomePage.class);
            startActivity(intent);
        }
    }
}