package com.rachit.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rachit.recyclerview.R;

import java.util.List;

public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.SimpleViewHolder> {

    List<String> simpleList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(String data);
    }

    public SimpleRecyclerViewAdapter(List<String> simpleList, Context context, OnItemClickListener onItemClickListener) {
        this.simpleList = simpleList;
        this.onItemClickListener = onItemClickListener;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        protected TextView text;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.simple_text);
        }
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row_layout_simple, parent, false);
        return new SimpleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SimpleRecyclerViewAdapter.SimpleViewHolder holder, int position) {
        holder.text.setText(simpleList.get(position));
    }

    @Override
    public int getItemCount() {
        return simpleList.size();
    }
}