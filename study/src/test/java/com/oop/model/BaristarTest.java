package com.oop.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaristarTest {

    @Test
    public void makeCoffee() {
        Baristar baristar = new Baristar();
        for (MenuItem item : MenuItem.values()) {
            Coffee result = baristar.makeCoffee(item);
            assertThat(result).isEqualTo(new Coffee(item));
        }
    }
}