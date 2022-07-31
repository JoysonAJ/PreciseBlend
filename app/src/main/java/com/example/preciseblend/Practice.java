package com.example.preciseblend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class Practice extends Fragment {
    View view;
    ImageButton github,replit,hackerRank,leetCode,codeChief,interviewBit,codeForces;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_practice, container, false);


         github = (ImageButton)view.findViewById(R.id.github);
         replit = view.findViewById(R.id.replit);
         hackerRank = view.findViewById(R.id.hackerrank);
         leetCode = view.findViewById(R.id.leetcode);
         codeChief = view.findViewById(R.id.codechief);
         codeForces = view.findViewById(R.id.codeforce);
         interviewBit = view.findViewById(R.id.interviewbit);

         github.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com")));
             }
         });

        replit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://replit.com/")));
            }
        });

        hackerRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hackerrank.com/")));
            }
        });

        leetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://leetcode.com/")));
            }
        });

        codeChief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.codechef.com/")));
            }
        });

        codeForces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://codeforces.com/")));
            }
        });

        interviewBit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.interviewbit.com/")));
            }
        });

        return view;
    }
}