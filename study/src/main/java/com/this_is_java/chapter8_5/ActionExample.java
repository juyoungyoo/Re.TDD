package com.this_is_java.chapter8_5;

public class ActionExample {

    public static void main(String[] args) {
        Action action = () -> System.out.println("복사를 합니다");
        /* 동일
        Action action = new Action(){
            @Override
            public void work() {
                System.out.println("복사를 합니다");
            }
        };
        */
        action.work();
    }
}
