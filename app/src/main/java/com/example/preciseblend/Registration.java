package com.example.preciseblend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText username, userEmail, userPassword, ConfirmPassword;
//    String name, email, password, cofrmPassword;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    Button SignUp, LoginPage;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.userName);
        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.Confirmpassword);


        String name =  username.getText().toString();
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();
        String cofrmPassword = ConfirmPassword.getText().toString();

        mAuth = FirebaseAuth.getInstance();

        SignUp = findViewById(R.id.signIn);
        LoginPage = findViewById(R.id.Login);



        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText().toString()) && TextUtils.isEmpty(userEmail.getText().toString()) && TextUtils.isEmpty(userPassword.getText().toString()) && TextUtils.isEmpty(ConfirmPassword.getText().toString())) {
                    Toast.makeText(Registration.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                } else {
                    if (userPassword.getText().toString().equals(ConfirmPassword.getText().toString())) {
                        mAuth.createUserWithEmailAndPassword(userEmail.getText().toString(), userPassword.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        FirebaseUser user = null;
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Toast.makeText(Registration.this, "Registeration Sucessfull", Toast.LENGTH_LONG).show();
                                            user = mAuth.getCurrentUser();
//
                                            Intent intent = new Intent(Registration.this, HomePage.class);
                                            startActivity(intent);
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(Registration.this, "Authentication failed.", Toast.LENGTH_LONG).show();
//                                        updateUI(user);
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(Registration.this, "Password Should match", Toast.LENGTH_LONG).show();
                    }
                }
            }
//            }
        });
    }

    public void SwitchToLogin(View view) {
        Intent intent = new Intent(Registration.this, MainActivity.class);
        startActivity(intent);
    }
}









