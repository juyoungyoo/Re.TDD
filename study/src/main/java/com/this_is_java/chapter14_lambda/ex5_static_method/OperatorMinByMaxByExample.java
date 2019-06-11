package com.this_is_java.chapter14_lambda.ex5_static_method;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class OperatorMinByMaxByExample {

    private static Fruit strawberry = new Fruit("딸기", 6000);
    private static Fruit watermelon = new Fruit("수박", 10000);

    public static void main(String[] args) {
        // 가격 비교해서 큰 T 반환
        Fruit expensiveFruit = getFruitBinaryOperator(BinaryOperator.maxBy(Comparator.comparingInt(Fruit::getPrice)));
        printResult(expensiveFruit);

        // 가격 비교해서 작은 T 반환
        Fruit chipFruit = getFruitBinaryOperator(BinaryOperator.minBy(Comparator.comparingInt(Fruit::getPrice)));
        printResult(chipFruit);
    }

    private static Fruit getFruitBinaryOperator(BinaryOperator<Fruit> operator) {
        return operator.apply(strawberry, watermelon);
    }

    private static void printResult(Fruit fruit){
        System.out.println("[이름: " + fruit.name + ", 가격: " + fruit.price + "]");
    }


    static class Fruit {
        private final String name;
        private final int price;

        public Fruit(String name,
                     int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }
}
