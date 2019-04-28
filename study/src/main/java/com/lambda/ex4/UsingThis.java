package com.lambda.ex4;

public class UsingThis {

    public int outterValue = 10;

    class Inner {
        int innerValue = 20;

        void method() {
            MyFunctionalInterface fi = () -> {
                System.out.println("outter value : " + outterValue);
                System.out.println("outter value : " + UsingThis.this.outterValue);

                System.out.println("inner value : " + innerValue);
                System.out.println("inner value : " + this.innerValue);
            };
            fi.method();
        }
    }
}
