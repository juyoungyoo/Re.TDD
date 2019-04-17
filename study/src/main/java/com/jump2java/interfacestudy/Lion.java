package com.jump2java.interfacestudy;

public class Lion extends Predator implements Barkable{
    @Override
    public String getFood() {
        return "banana";
    }

    @Override
    public void bark() {
        System.out.println(":::Lion 으르렁");
    }

}
