package com.tdd.blackjack.model.person;

import com.tdd.blackjack.AbstractTestBase;
import com.tdd.blackjack.model.card.Card;
import com.tdd.blackjack.model.card.Rank;
import com.tdd.blackjack.model.card.Shape;
import com.tdd.blackjack.model.person.Dealer;
import com.tdd.blackjack.model.person.Cards;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DealerTest extends AbstractTestBase {

    private Dealer dealer;

    @Before
    public void setUp() {
        dealer = new Dealer(new Cards());
        assertThat(dealer.getCards()).isNotNull();
    }

    @Test
    public void dealer_initializer() {
        dealer = new Dealer(new Cards());
        assertThat(dealer.getCards()).isNotNull();
    }


    @Test
    public void dealer_receive_one_card() {
        Card card = ofCard(Shape.SPADES, Rank.FIVE);

        dealer.receive(card);

        assertThat(dealer.getCards()).size().isEqualTo(1);
        assertThat(dealer.getCards()).contains(card);
    }

    @Test
    public void dealer_receive_two_cards() {
        List<Card> cards = ofCards(ofCard(Shape.SPADES, Rank.FIVE),ofCard(Shape.SPADES, Rank.FIVE));

        for (Card card: cards) {
            dealer.receive(card);
        }

        assertThat(dealer.getCards()).contains(cards.get(0), cards.get(1));
        assertThat(dealer.getCards()).hasSize(2);
    }

    @Test
    public void dealer_result_score_when_FIVE_and_TEN() {
        List<Card> cards = ofCards(ofCard(Shape.SPADES, Rank.FIVE),ofCard(Shape.SPADES, Rank.TEN));

        dealer.receive(cards.get(0));
        dealer.receive(cards.get(1));

        int resultScore = dealer.getResultScore();

        assertThat(resultScore).isEqualTo(15);
    }

    @Test
    public void dealer_receive_fail_when_TEN_TEN_SIX() {
        List<Card> cards = ofCards(ofCard(Shape.SPADES, Rank.TEN),ofCard(Shape.HEARTS, Rank.TEN), ofCard(Shape.SPADES, Rank.SIX));

        Throwable thrown = catchThrowable(() -> cards.stream().forEach(e->dealer.receive(e)));

        assertThat(thrown).hasMessage(":: 딜러 :: 더이상 받을 수 없습니다");
    }




}