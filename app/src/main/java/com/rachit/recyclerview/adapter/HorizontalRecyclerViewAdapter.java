package com.rachit.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rachit.recyclerview.R;
import com.rachit.recyclerview.model.ComplexDataBean;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalViewHolder> {

    List<ComplexDataBean> complexList;

    public HorizontalRecyclerViewAdapter(List<ComplexDataBean> complexList, Context context) {
        this.complexList = complexList;
    }

    public static class HorizontalViewHolder extends RecyclerView.ViewHolder {
        protected ImageView person;
        protected TextView name;
        protected TextView number;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            person = (ImageView) itemView.findViewById(R.id.person);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
        }
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row_layout_horizontal, parent, false);
        return new HorizontalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        holder.name.setText(complexList.get(position).getName());
        holder.number.setText(complexList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return complexList.size();
    }
}