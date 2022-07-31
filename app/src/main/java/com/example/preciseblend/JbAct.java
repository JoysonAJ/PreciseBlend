package com.example.preciseblend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JbAct extends AppCompatActivity {
    Button backHome;

    Button indeed, glassDoor, getWork, linkdIn, angleList, naukri;
    Button searchApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jb);

        backHome = findViewById(R.id.JobBack);

        indeed = findViewById(R.id.indeed);
        glassDoor = findViewById(R.id.glassDoor);
        getWork = findViewById(R.id.getWork);
        linkdIn = findViewById(R.id.linkedIn);
        angleList = findViewById(R.id.angeList);
        naukri = findViewById(R.id.naukri);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JbAct.this, HomePage.class);
                startActivity(intent);
            }
        });

        indeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.indeed.com/?from=gnav-homepage")));
            }
        });

        glassDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.glassdoor.co.in/index.htm")));
            }
        });

        getWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://getwork.org/")));
            }
        });

        linkdIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.linkedin.com/jobs/jobs-in-mangaluru?trk=homepage-basic_guest_nav_menu_jobs&position=1&pageNum=0")));
            }
        });
        angleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://angel.co/")));
            }
        });

        naukri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naukri.com/")));
            }
        });

    }
}