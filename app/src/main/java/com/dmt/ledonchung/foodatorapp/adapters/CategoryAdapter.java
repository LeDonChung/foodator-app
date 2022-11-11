package com.dmt.ledonchung.foodatorapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.ledonchung.foodatorapp.R;
import com.dmt.ledonchung.foodatorapp.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder>{
    private final List<Category> list;
    private Context context;
    public CategoryAdapter(List<Category> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_categories_layout, parent, false
        );
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = list.get(position);

        holder.titleCategory.setText(category.getTitle());

        int drawableRes = holder.itemView.getContext().getResources()
                .getIdentifier(category.getPicture(), "drawable", holder.itemView.getContext().getPackageName());

        Picasso.get()
                .load(drawableRes)
                .into(holder.picCategory);

        holder.itemCategoryLayout.setOnClickListener(v -> {
            //
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder{
        private CardView itemCategoryLayout;
        private ImageView picCategory;
        private TextView titleCategory;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            itemCategoryLayout = itemView.findViewById(R.id.item_category_layout);
            picCategory = itemView.findViewById(R.id.pic_category);
            titleCategory = itemView.findViewById(R.id.title_category);
        }
    }

}
