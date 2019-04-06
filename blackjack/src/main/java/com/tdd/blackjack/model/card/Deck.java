package com.tdd.blackjack.model.card;


import java.util.*;

public class Deck {

    private static final int DEFAULT_CARD_TOTAL_SIZE = 52;

    private static Stack<Card> deck;

    public Deck() {
        new Deck(this.create());
    }

    public Deck(Stack<Card> cards) {
        this.deck = cards;
    }

    public Stack<Card> create() {
        Stack<Card> cards = new Stack<>();
        for(Shape shape : Shape.values()){
            for (Rank rank: Rank.values()) {
                cards.add(Card.of(shape, rank));
            }
        }
        return cards;
//      .map(shape -> Arrays.stream(Card.Rank.values()).map(rank -> new Card(rank, shape)))
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }


    public static int getDefaultCardTotalSize() {
        return DEFAULT_CARD_TOTAL_SIZE;
    }

    public Card sendCard() {
        return deck.pop();
    }

    public int size() {
        return deck.size();
    }
}