package com.dmt.ledonchung.foodatorapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.ledonchung.foodatorapp.R;
import com.dmt.ledonchung.foodatorapp.interfaces.ChangeNumberItemsListener;
import com.dmt.ledonchung.foodatorapp.models.Food;
import com.dmt.ledonchung.foodatorapp.models.ManagementCart;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    private List<Food> foods;
    private ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(List<Food> foods, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.foods = foods;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart_layout, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        Food food = foods.get(position);

        holder.titleFood.setText(food.getTitle());
        holder.feeFood.setText(String.format("%s", food.getFee()));
        holder.totalFee_cart.setText(String.format("%s", Math.round(food.getNumberInCart() * food.getFee() * 100 / 100)));
        holder.numberIn_cart.setText(String.format("%s", food.getNumberInCart()));
        int drawableRes = holder.itemView.getContext().getResources()
                .getIdentifier(food.getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Picasso.get()
                .load(drawableRes)
                .into(holder.picFood);

        holder.minusCart.setOnClickListener(v -> {
            managementCart.minusNumberFood(foods, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });
        });

        holder.plusCart.setOnClickListener(v -> {
            managementCart.plushNumberFood(foods, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });
        });



    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        private final ImageView picFood;
        private final TextView titleFood;
        private final TextView feeFood;
        private final TextView totalFee_cart;
        private final TextView numberIn_cart;
        private final ImageView minusCart;
        private final ImageView plusCart;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            picFood = itemView.findViewById(R.id.pic_food);
            titleFood = itemView.findViewById(R.id.title_food);
            feeFood = itemView.findViewById(R.id.fee_food);
            totalFee_cart = itemView.findViewById(R.id.total_fee_cart);
            numberIn_cart = itemView.findViewById(R.id.number_in_cart);
            minusCart = itemView.findViewById(R.id.minus_cart);
            plusCart = itemView.findViewById(R.id.plus_cart);
        }
    }
}
