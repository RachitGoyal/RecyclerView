package com.rachit.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rachit.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    Button mSimpleRecyclerView, mComplexRecyclerView, mHorizontalRecyclerView, mGridRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSimpleRecyclerView = (Button) findViewById(R.id.simple_recycler_view_button);
        mComplexRecyclerView = (Button) findViewById(R.id.complex_recycler_view_button);
        mHorizontalRecyclerView = (Button) findViewById(R.id.horizontal_recycler_view_button);
        mGridRecyclerView = (Button) findViewById(R.id.grid_recycler_view_button);

        mSimpleRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SimpleRecyclerViewActivity.class));
            }
        });

        mComplexRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ComplexRecyclerViewActivity.class));
            }
        });

        mHorizontalRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HorizontalRecyclerViewActivity.class));
            }
        });

        mGridRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridRecyclerViewActivity.class));
            }
        });

    }
}