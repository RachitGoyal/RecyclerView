package com.rachit.recyclerview.activity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.rachit.recyclerview.R;
import com.rachit.recyclerview.adapter.SimpleRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SimpleRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mSimpleRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    List<String> mDummyData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Simple Recycler View");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSimpleRecyclerView = (RecyclerView) findViewById(R.id.simple_recycler_view);

        createDummyData(100);

        layoutManager = new LinearLayoutManager(this);
        mSimpleRecyclerView.setLayoutManager(layoutManager);
        mSimpleRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext()));
        mSimpleRecyclerView.addItemDecoration(
                new DividerItemDecoration(getApplicationContext(), R.drawable.divider));
        adapter = new SimpleRecyclerViewAdapter(mDummyData, this,
                new SimpleRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(String data) {
                        // Implement our action here
                        Toast.makeText(SimpleRecyclerViewActivity.this, "Item Clicked" + data, Toast.LENGTH_SHORT).show();
                    }
                });
        mSimpleRecyclerView.setAdapter(adapter);
    }

    private void createDummyData(int size) {
        for (int i = 0; i < size; i++) {
            mDummyData.add("Data " + (i + 1));
        }
    }

    public class DividerItemDecoration extends RecyclerView.ItemDecoration {

        private final int[] ATTRS = new int[]{android.R.attr.listDivider};

        private Drawable mDivider;

        /**
         * Default divider will be used
         */
        public DividerItemDecoration(Context context) {
            final TypedArray styledAttributes = context.obtainStyledAttributes(ATTRS);
            mDivider = styledAttributes.getDrawable(0);
            styledAttributes.recycle();
        }

        /**
         * Custom divider will be used
         */
        public DividerItemDecoration(Context context, int resId) {
            mDivider = ContextCompat.getDrawable(context, resId);
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }

}
