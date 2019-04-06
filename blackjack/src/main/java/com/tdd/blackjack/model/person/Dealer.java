package com.tdd.blackjack.model.person;


import com.tdd.blackjack.model.card.Card;

import java.util.List;

public class Dealer{

    private Cards cards;

    private final int DEALER_CONDITION_HIT = 17;

    public Dealer() {
        this.cards = new Cards();
    }

    public Dealer(Cards cards) {
        this.cards = cards;
    }

    public void receive(Card sendCard) {
        if(DEALER_CONDITION_HIT < cards.calculatorScore(this.cards.getCards())){
            throw new IllegalArgumentException(":: 딜러 :: 더이상 받을 수 없습니다");
        }
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
        return "Dealer { " +
                "currentScore= " + getResultScore() + "\n" +
                "Cards=" + this.cards.toString()  + "\n" +
                "}";
    }
}
