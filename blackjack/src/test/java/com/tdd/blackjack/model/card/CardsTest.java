package com.tdd.blackjack.model.card;

import com.tdd.blackjack.AbstractTestBase;
import com.tdd.blackjack.model.person.Cards;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CardsTest extends AbstractTestBase {


    private Cards cards;

    @Before
    public void setUp(){
        cards = new Cards();
    }

    @Test
    public void cards_calculator_when_five_and_six() {
        List<Card> ofCards = ofCards(ofCard(Shape.DIAMONDS,Rank.FIVE), ofCard(Shape.SPADES, Rank.SIX));
        int result = cards.calculatorScore(ofCards);
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void cards_calculator_when_ten_and_ace() {
        List<Card> ofCards = ofCards(ofCard(Shape.DIAMONDS,Rank.TEN), ofCard(Shape.SPADES, Rank.ACE));
        int result = cards.calculatorScore(ofCards);
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void print() {
        List<Card> ofCards = ofCards(ofCard(Shape.DIAMONDS,Rank.TEN), ofCard(Shape.SPADES, Rank.ACE));
        System.out.println(cards.toString());
    }

}