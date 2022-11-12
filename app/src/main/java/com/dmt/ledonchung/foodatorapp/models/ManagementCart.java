package com.dmt.ledonchung.foodatorapp.models;

import android.content.Context;

import com.dmt.ledonchung.foodatorapp.interfaces.ChangeNumberItemsListener;

import java.util.ArrayList;
import java.util.List;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public boolean insertFood(Food item) {
        List<Food> listFood = getListCart();

        // Lấy index xuất hiện của item dựa trên title
        int index = listFood.indexOf(item);

        // Nếu index nhỏ hơn 0 nghĩa là đã tồn tại thì thêm nó vào listFood
        // Ngược lại thì setNumberInCart
        if (index < 0) {
            listFood.add(item);
        } else {
            listFood.get(index).setNumberInCart(item.getNumberInCart());
        }

        this.tinyDB.putListObject("cardlist", (ArrayList<Food>) listFood);
        return true;
    }

    public List<Food> getListCart() {
        return this.tinyDB.getListObject("cardlist");
    }

    public void plushNumberFood(List<Food> foods, int pos, ChangeNumberItemsListener changeNumberItemsListener) {
        foods.get(pos).setNumberInCart(foods.get(pos).getNumberInCart() + 1);
        tinyDB.putListObject("cardlist", (ArrayList<Food>) foods);
        changeNumberItemsListener.change();
    }

    public void minusNumberFood(List<Food> foods, int pos, ChangeNumberItemsListener changeNumberItemsListener) {
        if (foods.get(pos).getNumberInCart() == 1) {
            foods.remove(pos);
        } else {
            foods.get(pos).setNumberInCart(foods.get(pos).getNumberInCart() - 1);
        }
        tinyDB.putListObject("cardlist", (ArrayList<Food>) foods);
        changeNumberItemsListener.change();
    }

    public double getTotalFee() {
        double sum = 0;
        for (Food f : getListCart()) {
            sum += (f.getFee() * f.getNumberInCart());
        }
        return sum;
    }
}
