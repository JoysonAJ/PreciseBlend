package com.example.preciseblend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrepActy extends AppCompatActivity {

    Button backHome,tutorialFrg,practiceFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep_acty);

        backHome = findViewById(R.id.bkHome);
        tutorialFrg = findViewById(R.id.tutorials);
        practiceFrg = findViewById(R.id.pract);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( PrepActy.this,HomePage.class);
                startActivity(intent);
            }
        });

        tutorialFrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentSwitch(new Tutorials());
            }
        });

        practiceFrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentSwitch(new Practice());
            }
        });
    }

    private void fragmentSwitch(Fragment fragment) {
        FragmentManager fragment_manager = getSupportFragmentManager();
        FragmentTransaction fragment_Transaction = fragment_manager.beginTransaction();
        fragment_Transaction.replace(R.id.frame,fragment).commit();
    }
}
/*
    Button backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

        backHome = findViewById(R.id.bkHome);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( portalAct.this,HomePage.class);
                startActivity(intent);
            }
        });*/