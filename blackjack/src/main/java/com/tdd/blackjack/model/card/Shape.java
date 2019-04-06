package com.tdd.blackjack.model.card;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Shape{

    CLUBS("︎♣︎"), DIAMONDS("♦︎"), HEARTS("♥︎"), SPADES("♠︎");
    private String shape;

}
