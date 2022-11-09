package com.dmt.ledonchung.foodatorapp.models;

public class Food {
    private String title, pic, description;
    private double fee;
    private int numberInCart;

    public Food() {
        this("don't have", "don't have", "don't have", 0);
    }
    public Food(String title, String pic, String description, double fee) {
        setTitle(title);
        setPic(pic);
        setDescription(description);
        setFee(fee);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.trim().equals("")) {
            this.title = "don't have";
        } else {
            this.title = title;
        }
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        if(pic.trim().equals("")) {
            this.pic = "don't have";
        } else {
            this.pic = pic;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.trim().equals("")) {
            this.description = "don't have";
        } else {
            this.description = description;
        }
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        if(fee < 0) {
            this.fee = 0;
        } else {
            this.fee = fee;
        }
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        if(numberInCart < 0) {
            this.numberInCart = 0;
        } else {
            this.numberInCart = numberInCart;
        }
    }
}
