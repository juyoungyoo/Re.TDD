package com.oop.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    @Test
    public void menuList() {
        Menu menu = Menu.of();
        List<MenuItem> result = menu.getMenuItems();
        assertThat(result).size().isEqualTo(4);
        assertThat(result).containsExactly(MenuItem.values());
    }

    @Test
    public void chooseMenu_By_AMERICANO() {
        Menu menu = Menu.of();

        MenuItem result = menu.choose(MenuItem.AMERICANO);

        assertThat(result).isEqualTo(MenuItem.AMERICANO);
        assertThat(result.getPrice()).isEqualTo(MenuItem.AMERICANO.getPrice());
    }
}