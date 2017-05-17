package com.kurone.ireader.entity;

/**
 * Created by qihao on 2017/5/16.
 */

public class Book {
    private int icon;
    private String name;

    public Book() {
    }

    public Book(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
