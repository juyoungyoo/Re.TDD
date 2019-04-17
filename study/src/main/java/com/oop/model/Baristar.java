package com.oop.model;

public class Baristar {

    public static Baristar of() {
        return new Baristar();
    }

    public Coffee makeCoffee(MenuItem menuItem) {
        return new Coffee(menuItem);
    }
}
