package com.example.oneclickbite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    ArrayList mylist;
    Context context;


    public CustomAdapter(Context context, ArrayList mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        CustomAdapter.ViewHolder viewHolder = new CustomAdapter.ViewHolder(view);

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder viewHolder, int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.pos.setText(String.valueOf(position+1));
        viewHolder.text.setText((String) mylist.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mylist.size();
    }

    // Initiating the views
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView pos, text;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            pos = (TextView) view.findViewById(R.id.pos);
            text = (TextView) view.findViewById(R.id.text);
        }

    }

}
