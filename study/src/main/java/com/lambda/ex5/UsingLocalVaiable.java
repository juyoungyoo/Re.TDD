package com.lambda.ex5;

public class UsingLocalVaiable {
    void method(int arg) {
        int localValue = 40;


//        arg = 40;  error
//        localValue = 40;     error

        MyFunctionalInterface fi = ()->{
            System.out.println(arg);
            System.out.println(localValue);
        };
        fi.method();
    }

    public static void main(String[] args) {
        UsingLocalVaiable ulv = new UsingLocalVaiable();
        ulv.method(5);
    }
}
