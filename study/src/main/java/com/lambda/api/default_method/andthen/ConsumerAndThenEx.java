package com.lambda.api.default_method.andthen;

import java.util.function.Consumer;

public class ConsumerAndThenEx {

    public static void main(String[] args) {
        Consumer<Member> consumerA = (m) -> {
            System.out.println(m.getName());
        };
        Consumer<Member> consumerB = (m) -> {
            System.out.println(m.getId());
        };
        Consumer<Member> consumerC = (m) -> {
            System.out.println(m.getAddress());
        };
        Consumer<Member> consumerAB = consumerA.andThen(consumerB).andThen(consumerC);

        consumerAB.accept(new Member("홍길동", "hong", null));
    }
}
