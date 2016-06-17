package com.rachit.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.rachit.recyclerview.R;
import com.rachit.recyclerview.adapter.ComplexRecyclerViewAdapter;
import com.rachit.recyclerview.model.ComplexDataBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComplexRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mComplexRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] nameList = {"Abc", "Def", "Ghi", "Jkl", "Mno", "Pqr", "Stu", "Vwx", "Yzz"};
    private String[] typeList = {"Engineer", "Doctor", "Cricketer", "Footballer", "Scientist", "Shopkeeper", "Salesman", "Student", "Teacher"};

    List<ComplexDataBean> mDummyData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Complex Recycler View");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mComplexRecyclerView = (RecyclerView) findViewById(R.id.complex_recycler_view);

        createDummyData(100);

        layoutManager = new LinearLayoutManager(this);
        mComplexRecyclerView.setLayoutManager(layoutManager);

        adapter = new ComplexRecyclerViewAdapter(mDummyData, getApplicationContext());
        mComplexRecyclerView.setAdapter(adapter);
    }

    private void createDummyData(int size) {
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            ComplexDataBean dataBean = new ComplexDataBean();
            dataBean.setName(nameList[random.nextInt(9)]);
            dataBean.setType(typeList[random.nextInt(9)]);
            dataBean.setNumber(String.valueOf(9000000000L + random.nextInt(999999999)));
            dataBean.setFav(random.nextBoolean());
            mDummyData.add(dataBean);
        }
    }
}
