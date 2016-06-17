package com.rachit.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.rachit.recyclerview.R;
import com.rachit.recyclerview.adapter.GridRecyclerViewAdapter;
import com.rachit.recyclerview.model.ComplexDataBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mGridRecyclerView;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager mGridLayoutManager;

    private String[] nameList = {"Abc", "Def", "Ghi", "Jkl", "Mno", "Pqr", "Stu", "Vwx", "Yzz"};

    List<ComplexDataBean> mDummyData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Grid Recycler View");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mGridRecyclerView = (RecyclerView) findViewById(R.id.grid_recycler_view);

        createDummyData(100);

        mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        mGridRecyclerView.setLayoutManager(mGridLayoutManager);

        adapter = new GridRecyclerViewAdapter(mDummyData, getApplicationContext());
        mGridRecyclerView.setAdapter(adapter);

    }

    private void createDummyData(int size) {
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            ComplexDataBean dataBean = new ComplexDataBean();
            dataBean.setName(nameList[random.nextInt(8)]);
            dataBean.setNumber(String.valueOf(9000000000L + random.nextInt(999999999)));
            mDummyData.add(dataBean);
        }
    }

}
