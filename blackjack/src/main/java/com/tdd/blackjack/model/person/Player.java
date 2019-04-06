package com.tdd.blackjack.model.person;

import com.tdd.blackjack.model.card.Card;

import java.util.List;

public class Player{

    private Cards cards;

    public Player() {
        this.cards = new Cards();
    }

    public Player(Cards cards) {
        this.cards = cards;
    }

    public void receive(Card sendCard) {
        cards.add(sendCard);
    }

    public List<Card> getCards(){
        return cards.getCards();
    }

    public int getResultScore() {
        return cards.calculatorScore(cards.getCards());
    }


    @Override
    public String toString() {
        return "Player { " +
                "currentScore= " + getResultScore() + "\n" +
                "Cards=" + this.cards.toString()  + "\n" +
                "}";
    }
}
