package com.example.preciseblend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private String use="User1";
    private String psw="1234";
    TextView username,Password;
    Button login,googleLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        username = findViewById(R.id.usn);
        Password = findViewById(R.id.pas);

        login = findViewById(R.id.Login);
//        googleLogin = findViewById(R.id.GoogleLogin);

        String email = username.getText().toString();
        String password = Password.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("") || Password.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                } else {
                    mAuth.signInWithEmailAndPassword(username.getText().toString(), Password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(MainActivity.this, "LOGED IN SUCESSFULL", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                                        startActivity(intent);
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });

    }

    private void updateUI(FirebaseUser user) {
    }

    public void SwitchUser(View view) {
        Intent intent =new Intent(MainActivity.this,Registration.class);
        startActivity(intent);
    }
}






