package com.oop.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Coffee {

    private String name;
    private int price;

    public Coffee(MenuItem menuItem) {
        this.name = menuItem.name();
        this.price = menuItem.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return price == coffee.price &&
                Objects.equals(name, coffee.name);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
