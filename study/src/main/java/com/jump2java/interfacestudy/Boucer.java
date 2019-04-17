package com.jump2java.interfacestudy;

public class Boucer {

    private void barkAnimal(Barkable animal){
        animal.bark();
    }

    public static void main(String[] args){
        Boucer boucer = new Boucer();
        boucer.barkAnimal(new Tiger());
        boucer.barkAnimal(new Lion());
    }
}
