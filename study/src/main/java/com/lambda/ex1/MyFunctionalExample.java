package com.lambda.ex1;

public class MyFunctionalExample {

    public static void main(String[] args) {
        MyFunctionInterface fi;

        fi = () -> {
            String str = "method call";
            System.out.println(str);
        };
        fi.method();

        fi = () -> {
            System.out.println("method call2");
        };
        fi.method();

        fi = () -> System.out.println("method call3");
        fi.method();
    }
}
