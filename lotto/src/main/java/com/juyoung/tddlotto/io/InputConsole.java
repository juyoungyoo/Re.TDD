package com.juyoung.tddlotto.io;

import java.util.Scanner;

public class InputConsole {

    static Scanner scan = new Scanner(System.in);

    public static int buyTicket(){
        System.out.println("몇 장을 구매하시겠습니까?");
        return scan.nextInt();
    }

    public static int inputMoney() {
        System.out.println("금액을 입력하세요.");
        return scan.nextInt();
    }
}
