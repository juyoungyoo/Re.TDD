package com.jump2java.interfacestudy;

public abstract class Predator extends Animal{
    public abstract String getFood();

    public boolean isPredator(){
        return true;
    }
}
