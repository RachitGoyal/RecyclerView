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

public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<ComplexRecyclerViewAdapter.ComplexViewHolder> {

    List<ComplexDataBean> complexList;

    public ComplexRecyclerViewAdapter(List<ComplexDataBean> complexList, Context context) {
        this.complexList = complexList;
    }

    public static class ComplexViewHolder extends RecyclerView.ViewHolder {
        protected ImageView person;
        protected ImageView star;
        protected TextView name;
        protected TextView number;
        protected TextView type;

        public ComplexViewHolder(View itemView) {
            super(itemView);
            person = (ImageView) itemView.findViewById(R.id.person);
            star = (ImageView) itemView.findViewById(R.id.star);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
            type = (TextView) itemView.findViewById(R.id.type);
        }
    }

    @Override
    public ComplexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row_layout_complex, parent, false);
        return new ComplexViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComplexViewHolder holder, int position) {
        holder.name.setText(complexList.get(position).getName());
        holder.number.setText(complexList.get(position).getNumber());
        holder.type.setText(complexList.get(position).getType());
        if (!complexList.get(position).isFav()) {
            holder.star.setVisibility(View.INVISIBLE);
        } else {
            holder.star.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return complexList.size();
    }
}