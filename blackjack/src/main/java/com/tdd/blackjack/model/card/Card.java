package com.tdd.blackjack.model.card;


import java.util.List;

public class Card {

    private Shape shape;    // 모양
    private Rank rank;      // score

    public static Card of(Shape shape, Rank rank) {
        return new Card(shape, rank);
    }

    public Card(Shape shape, Rank rank) {
        this.shape = shape;
        this.rank = rank;
    }

    public static int sum(List<Card> cards) {
        return Integer.parseInt(null);
    }

    public Shape getShape() {
        return shape;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "shape=" + shape +
                ", rank=" + rank +
                '}';
    }
}
