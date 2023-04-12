package com.example.oneclickbite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VarietyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<FoodClass> foodClassList;

    public VarietyAdapter(Context context, List<FoodClass> foodClassList) {
        this.context = context;
        this.foodClassList = foodClassList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(foodClassList.get(position).getFoodImage()).into(holder.recImage);
        holder.recTitle.setText(foodClassList.get(position).getFoodTitle());

        String food = holder.recTitle.getText().toString();
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context,RecipeOption.class);
                intent.putExtra("foodTag",food);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return foodClassList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle;
    CardView recCard;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recTitle = itemView.findViewById(R.id.recFood);


    }
}
