package com.tdd.baseballgame.io;

import java.util.Scanner;

public class InputConsole {

    private static Scanner scanner = new Scanner(System.in);

    public static String writeAnswer(){
        System.out.println("========================");
        System.out.println("정답을 입력하세요.");
        return scanner.nextLine();
    }

    public static String ask() {
        System.out.println("예상되는 답을 입력하세요.");
        return scanner.nextLine();
    }
}
