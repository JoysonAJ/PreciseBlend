package com.example.preciseblend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.preciseblend.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class PrepActy extends AppCompatActivity {

    //    ActivityMainBinding binding;
//    Button backHome,tutorialFrg,practiceFrg;
    Button backHome;

    BottomNavigationView bottomNavigationView;

    Tutorials tutorials = new Tutorials();
    Practice practice = new Practice();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep_acty);


        bottomNavigationView = findViewById(R.id.bottom_nav_bar_id);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, tutorials).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tutorials:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, tutorials).commit();
                        return true;

                    case R.id.pract:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, practice).commit();
                        return true;
                }
                return false;
            }
        });
        backHome = findViewById(R.id.bkHome);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrepActy.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}