package com.oop.model;

import lombok.Getter;

@Getter
public class Customer {

    private Coffee coffee;
    private static int money;

    public static Customer of(int initMoney) {
        money = initMoney;
        return new Customer();
    }

    public void order(MenuItem menuItem,
                      Menu menu,
                      Baristar baristar) {
        MenuItem choose = menu.choose(menuItem);
        Coffee coffee = baristar.makeCoffee(choose);
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public int getMoney() {
        return this.money;
    }

    public void pay(Coffee coffee) {
        this.money -= coffee.getPrice();
    }
}
