package com.jump2java.statictest;


class Singleton{

    private static Singleton one;

    private Singleton() {}

    public static Singleton getInstance(){
        if(one == null){
            one = new Singleton();
        }
        return one;
    }
}
public class SingletonTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}
