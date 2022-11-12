package com.dmt.ledonchung.foodatorapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.dmt.ledonchung.foodatorapp.R;
import com.dmt.ledonchung.foodatorapp.adapters.CartAdapter;
import com.dmt.ledonchung.foodatorapp.interfaces.ChangeNumberItemsListener;
import com.dmt.ledonchung.foodatorapp.databinding.ActivityCartActitivyBinding;
import com.dmt.ledonchung.foodatorapp.models.ManagementCart;
import com.google.android.material.navigation.NavigationBarView;

public class CartActivity extends AppCompatActivity {
    private ActivityCartActitivyBinding binding;
    private ManagementCart managementCart;
    private CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartActitivyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
        event();
    }

    public void initUI() {
        managementCart = new ManagementCart(this);
        cartAdapter = new CartAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calc();
            }
        });
        binding.listCart.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.listCart.setAdapter(cartAdapter);

    }

    private void calc() {
        double percentTax = 0.02;
        double delivery = 10;

        int tax = (int) (Math.round((managementCart.getTotalFee() * percentTax) * 100) / 100);
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100;

        binding.delivery.setText(String.format("$%f", delivery));
        binding.tax.setText(String.format("$%d", tax));
        binding.total.setText(String.format("$%f", total));
        binding.itemsTotal.setText(String.format("$%f", itemTotal));
    }

    public void event() {
        binding.fabCart.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CartAdapter.class);
            startActivity(intent);
        });

        binding.navMenu.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(CartActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                }
            }
        });
    }

}