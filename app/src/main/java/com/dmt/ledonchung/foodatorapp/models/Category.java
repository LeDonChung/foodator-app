package com.dmt.ledonchung.foodatorapp.models;

import java.io.Serializable;

public class Category implements Serializable {
    private String title, picture;

    public Category() {
        this("don't have", "don't have");
    }

    public Category(String title, String picture) {
        setTitle(title);
        setPicture(picture);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.trim().equals("")) {
            this.title = "don't have";
        } else {
            this.title = title;
        }
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        if (picture.trim().equals("")) {
            this.picture = "don't have";
        } else {
            this.picture = picture;
        }
    }
}
