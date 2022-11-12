package com.dmt.ledonchung.foodatorapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.ledonchung.foodatorapp.R;
import com.dmt.ledonchung.foodatorapp.interfaces.GoToDetailActivity;
import com.dmt.ledonchung.foodatorapp.models.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularHolder>{
    private final List<Food> list;
    private GoToDetailActivity goToDetailActivity;
    private Context context;
    public PopularAdapter(List<Food> list, GoToDetailActivity goToDetailActivity, Context context) {
        this.list = list;
        this.goToDetailActivity = goToDetailActivity;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_food_layout, parent, false
        );
        return new PopularHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularHolder holder, int position) {
        Food food = list.get(position);
        holder.add.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Add: "  + food.getTitle(), Toast.LENGTH_SHORT).show();
        });

        int drawableRes = holder.itemView.getContext().getResources()
                .getIdentifier(food.getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Picasso.get()
                .load(drawableRes)
                .into(holder.picFood);

        holder.itemFoodLayout.setOnClickListener(v -> {
            goToDetailActivity.sendObject(food);
        });

        holder.feeFood.setText(food.getFee() + "");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PopularHolder extends RecyclerView.ViewHolder{
        private CardView itemFoodLayout;
        private ImageView picFood;
        private TextView add;
        private TextView feeFood;

        public PopularHolder(@NonNull View itemView) {
            super(itemView);
            itemFoodLayout = itemView.findViewById(R.id.item_food_layout);
            picFood = itemView.findViewById(R.id.pic_food);
            add = itemView.findViewById(R.id.add);
            feeFood = itemView.findViewById(R.id.fee_food);
        }
    }

}
