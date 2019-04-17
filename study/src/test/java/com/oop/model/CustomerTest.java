package com.oop.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerTest {

    @Test
    public void 아메리카노를_주문한다() {
        Customer customer = Customer.of(0);
        customer.order(MenuItem.AMERICANO, Menu.of(), new Baristar());
    }

    @Test
    public void 아메리카노_값을_지불한다() {
        int money = 5000;
        int expected = money - MenuItem.AMERICANO.getPrice();

        Customer customer = Customer.of(money);
        customer.pay(new Coffee(MenuItem.AMERICANO));

        assertThat(customer.getMoney()).isEqualTo(expected);
    }
}