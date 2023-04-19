package com.example.oneclickbite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterIngrs extends RecyclerView.Adapter<CustomAdapterIngrs.ViewHolder> {

    ArrayList mylist;
    Context context;

    public CustomAdapterIngrs(Context context, ArrayList mylist) {
        this.mylist = mylist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapterIngrs.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_checkbox, parent, false);

        CustomAdapterIngrs.ViewHolder viewHolder = new CustomAdapterIngrs.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterIngrs.ViewHolder viewHolder, int position) {
        viewHolder.checkBox.setText((String) mylist.get(position));
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        public ViewHolder(@NonNull View view) {
            super(view);
            checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        }
    }
}
