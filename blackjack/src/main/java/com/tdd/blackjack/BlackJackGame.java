package com.tdd.blackjack;

import java.util.Scanner;

public class BlackJackGame {

    public static void main(String[] args) {

        Game game = new Game();
        game.initialization();

        Scanner scan = new Scanner(System.in);
        while(true){
            try {
                System.out.println("======== HIT 하시겠습니까? (quit: q) =========");
                String playerRequest = scan.next();
                if(playerRequest.equals("q")) break;

                game.receiveCardDealer();
                game.receiveCardPlayer();
                System.out.println(game.toString());

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        // 3. 결과 확인
        System.out.println(game.toString());
        game.result();
    }
}
