package com.oop.model;

public enum MenuItem {

    AMERICANO(1_000),
    CAPPUCCINO(2_000),
    MACCHIATO(3_000),
    ESPRESSO(4_000);

    private int price;

    MenuItem(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
