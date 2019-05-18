package com.tdd.baseballgame;

import com.tdd.baseballgame.model.Numbers;

import java.util.Scanner;

public class BaseballGameConsole {
    public static void main(String[] args) {

        System.out.println("==========정답을 생성합니다 ==========");
        Numbers answer = Numbers.of(1,7,0);

        Scanner scanner = new Scanner(System.in);
        int i =1;
        do{
            System.out.println("==========정답을 물어본다 (숫자는 ,로 구분)==========");
            String input = scanner.nextLine();

            Numbers.of();


        }while (i > 9);




        System.out.println();
    }
}
