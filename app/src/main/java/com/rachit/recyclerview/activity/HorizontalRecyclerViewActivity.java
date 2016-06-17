package com.rachit.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.rachit.recyclerview.R;
import com.rachit.recyclerview.adapter.HorizontalRecyclerViewAdapter;
import com.rachit.recyclerview.model.ComplexDataBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorizontalRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mHorizontalRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] nameList = {"Abc", "Def", "Ghi", "Jkl", "Mno", "Pqr", "Stu", "Vwx", "Yzz"};

    List<ComplexDataBean> mDummyData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Horizontal Recycler View");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mHorizontalRecyclerView = (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        createDummyData(100);

        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView.setLayoutManager(layoutManager);

        adapter = new HorizontalRecyclerViewAdapter(mDummyData, getApplicationContext());
        mHorizontalRecyclerView.setAdapter(adapter);
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
