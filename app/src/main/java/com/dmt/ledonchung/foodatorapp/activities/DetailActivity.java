package com.dmt.ledonchung.foodatorapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.dmt.ledonchung.foodatorapp.R;
import com.dmt.ledonchung.foodatorapp.databinding.ActivityDetailBinding;
import com.dmt.ledonchung.foodatorapp.models.Food;
import com.dmt.ledonchung.foodatorapp.models.ManagementCart;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private Food food;
    private ActivityDetailBinding binding;
    private int numberOrder = 1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        setData();
        event();
    }
    public void initUI() {
        managementCart = new ManagementCart(this);
    }
    public void getData() {
        Intent intent = getIntent();
        if(intent != null) {
            food = (Food) intent.getSerializableExtra("object");
            Toast.makeText(this, "food: " + food.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public void setData() {
        binding.titleDetail.setText(food.getTitle());

        binding.descriptionDetail.setText(food.getDescription());

        binding.feeDetail.setText(food.getFee() + "");

        binding.numberInCartDetail.setText(numberOrder + "");


        int drawableRes = getResources()
                .getIdentifier(food.getPic(), "drawable", getPackageName());

        Picasso.get()
                .load(drawableRes)
                .into(binding.picDetail);

    }

    public void event() {

        binding.minusDetail.setOnClickListener(v -> {
            if(numberOrder > 1) {
                numberOrder--;
            }
            binding.numberInCartDetail.setText(String.format("%s", numberOrder));
        });

        binding.plusDetail.setOnClickListener(v -> {
            numberOrder++;
            binding.numberInCartDetail.setText(String.format("%s", numberOrder));
        });

        binding.add.setOnClickListener(v -> {
            food.setNumberInCart(numberOrder);
            managementCart.insertFood(food);
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}