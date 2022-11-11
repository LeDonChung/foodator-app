package com.dmt.ledonchung.foodatorapp.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.dmt.ledonchung.foodatorapp.adapters.CategoryAdapter;
import com.dmt.ledonchung.foodatorapp.adapters.PopularAdapter;
import com.dmt.ledonchung.foodatorapp.databinding.ActivityMainBinding;
import com.dmt.ledonchung.foodatorapp.interfaces.GoToDetailActivity;
import com.dmt.ledonchung.foodatorapp.models.Category;
import com.dmt.ledonchung.foodatorapp.models.Food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
        event();
    }
    public void initUI() {
        getCategories();
        getFoods();

    }
    public void event() {
        binding.fabCart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
    public void getCategories() {
        List<Category> listCategories = new ArrayList<>();
        listCategories.add(new Category("Pizza", "cat_1"));
        listCategories.add(new Category("Burger", "cat_2"));
        listCategories.add(new Category("Hotdog", "cat_3"));
        listCategories.add(new Category("Drink", "cat_4"));
        listCategories.add(new Category("Donut", "cat_5"));

        CategoryAdapter categoryAdapter = new CategoryAdapter(listCategories, getApplicationContext());

        binding.rcvCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rcvCategories.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

    }
    public void getFoods() {
        List<Food> listFoods = new ArrayList<>();
        listFoods.add(new Food("Pepperoni pizza", "pizza", "slices pepperoni, cheese, fresh oregano, ground black pepper, pizza sauce", 9.76));
        listFoods.add(new Food("Cheese Burger", "pizza", "slices pepperoni, cheese, fresh oregano, ground black pepper, pizza sauce", 8));
        listFoods.add(new Food("Cheese Burger", "pizza", "slices pepperoni, cheese, fresh oregano, ground black pepper, pizza sauce", 5.6));
        listFoods.add(new Food("Cheese Burger", "pizza", "slices pepperoni, cheese, fresh oregano, ground black pepper, pizza sauce", 10.2));
        listFoods.add(new Food("Cheese Burger", "pizza", "slices pepperoni, cheese, fresh oregano, ground black pepper, pizza sauce", 4));
        listFoods.add(new Food("Cheese Burger", "pizza", "slices pepperoni, cheese, fresh oregano, ground black pepper, pizza sauce", 1));

        PopularAdapter popularAdapter = new PopularAdapter(listFoods, new GoToDetailActivity() {
            @Override
            public void sendObject(Food food) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("object", food);
                startActivity(intent);
            }
        }, getApplicationContext());

        binding.rcvPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rcvPopular.setAdapter(popularAdapter);
        popularAdapter.notifyDataSetChanged();


    }
}