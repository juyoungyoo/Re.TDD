package com.oop.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private static List<MenuItem> menuItems;

    private Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public static Menu of() {
        menuItems = Arrays.stream(MenuItem.values()).collect(Collectors.toList());
        return new Menu(menuItems);
    }

    public MenuItem choose(MenuItem menuItem) {
        return menuItems.stream().filter(item->item.equals(menuItem)).findFirst().orElse(null);
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}
