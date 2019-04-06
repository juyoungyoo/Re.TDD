package com.tdd.blackjack.model.person;

import com.tdd.blackjack.model.card.Card;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class Cards {

    private List<Card> cards;

    public Cards() {
        this.initialize();
    }

    public void initialize(){
        cards = Collections.emptyList();
        cards = new ArrayList<>();
    }

    public void add(Card sendCard) {
        cards.add(sendCard);
    }

    public int calculatorScore(List<Card> cards){
        int total = 0;
        for (Card card : cards) {
            total += card.getRank().getScore();
        }
        return total;
    }


    public int size(){
        return cards.size();
    }

    @Override
    public String toString() {
//        card
        return "Cards{" +
                    cards.stream().collect(Collectors.toList()) +
                '}';
    }
}
