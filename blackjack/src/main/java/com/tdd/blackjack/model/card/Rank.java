package com.tdd.blackjack.model.card;

import lombok.Getter;

@Getter
public enum Rank{

    ACE(1, 11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private int score;
    private int specialScore;

    Rank(int score) {
        this.score = score;
    }
    Rank(int score, int specialScore){
        this.score = score;
        this.specialScore = specialScore;
    }
}