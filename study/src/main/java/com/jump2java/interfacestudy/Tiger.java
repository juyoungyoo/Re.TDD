package com.jump2java.interfacestudy;

public class Tiger extends Predator implements Barkable {

    @Override
    public String getFood() {
        return "apple";
    }

    @Override
    public void bark() {
        System.out.println(":::Tiger 어흥");
    }
}
