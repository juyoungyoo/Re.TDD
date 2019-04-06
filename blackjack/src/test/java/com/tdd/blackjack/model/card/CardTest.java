package com.tdd.blackjack.model.card;


import com.tdd.blackjack.AbstractTestBase;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;


public class CardTest extends AbstractTestBase {

    @Test
    public void create_card_Clubs_Ace(){
        Shape shape = Shape.CLUBS;
        Rank rank = Rank.ACE;

        Card result = new Card(shape, rank);

        assertThat(result.getShape()).isEqualTo(shape);
        assertThat(result.getRank()).isEqualTo(rank);
    }

    @Test
    public void create_cards_when_Five_and_Six() {
        Card card = ofCard(Shape.CLUBS, Rank.FIVE);
        Card card2 = ofCard(Shape.HEARTS, Rank.SIX);

        List<Card> result = ofCards(card,card2);
        assertThat(result).size().isEqualTo(2);
        assertThat(result).contains(card, card2);
    }
}
