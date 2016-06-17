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

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.GridViewHolder> {

    List<ComplexDataBean> complexList;

    public GridRecyclerViewAdapter(List<ComplexDataBean> complexList, Context context) {
        this.complexList = complexList;
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder {
        protected ImageView person;
        protected TextView name;
        protected TextView number;

        public GridViewHolder(View itemView) {
            super(itemView);
            person = (ImageView) itemView.findViewById(R.id.person);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
        }
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row_layout_grid, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.name.setText(complexList.get(position).getName());
        holder.number.setText(complexList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return complexList.size();
    }
}