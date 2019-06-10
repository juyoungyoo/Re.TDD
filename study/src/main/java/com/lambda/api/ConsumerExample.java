package com.lambda.api;

import java.util.function.*;

public class ConsumerExample {
    public static void main(String[] args) {

        Consumer<String> consumer =  (x)-> System.out.println(x + "8");
        consumer.accept("java");

        BiConsumer<String,String> bigConsumer = (t, u)-> System.out.println(t + u);
        bigConsumer.accept("java", "8");

        DoubleConsumer doubleConsumer = d -> System.out.println(d);
        doubleConsumer.accept(8);

        IntConsumer intConsumer = i -> System.out.println(i);
        intConsumer.accept(8);

        // Type parameter 주의!
        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t+i);
        objIntConsumer.accept("java", 8);

    }
}
