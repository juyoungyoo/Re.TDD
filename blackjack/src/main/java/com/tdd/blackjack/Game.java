package com.tdd.blackjack;

import com.tdd.blackjack.model.card.Deck;
import com.tdd.blackjack.model.person.Dealer;
import com.tdd.blackjack.model.person.Player;
import lombok.Getter;

@Getter
public class Game {

    private Deck deck;
    private Dealer dealer;
    private Player player;

    public void initialization() {
        // 1. 카드 생성 및 셔플
        deck = new Deck();
        deck.shuffle();

        dealer = new Dealer();
        player = new Player();

        dealer.receive(deck.sendCard());
        dealer.receive(deck.sendCard());


        player.receive(deck.sendCard());
        player.receive(deck.sendCard());

        System.out.println(dealer.toString());
        System.out.println(player.toString());

    }

    public void receiveCardDealer(){
        dealer.receive(deck.sendCard());
    }
    public void receiveCardPlayer(){
        player.receive(deck.sendCard());
    }

    public void result(){
        int dealerResultScore = dealer.getResultScore();
        int playerResultScore = player.getResultScore();

        if(dealerResultScore == playerResultScore){
            System.out.println("무승부");
        }
        if(dealerResultScore < playerResultScore){
            System.out.println("Player 승");
        }
        if(dealerResultScore > playerResultScore){
            System.out.println("Dealer 승");
        }
    }


    @Override
    public String toString() {
        return "Game{" +
                "dealer=" + dealer.toString() +
                ", player=" + player.toString() +
                '}';
    }
}
