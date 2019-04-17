package com.oop;

import com.oop.model.Baristar;
import com.oop.model.Customer;
import com.oop.model.Menu;
import com.oop.model.MenuItem;

public class Console {

    public static void main(String[] args) {
        Customer customer = Customer.of(5000);
        customer.order(MenuItem.AMERICANO, Menu.of(), Baristar.of());
        System.out.println(customer.getCoffee().toString());

        customer.pay(customer.getCoffee());
        System.out.println("잔액조회 : " + customer.getMoney());
    }
}
