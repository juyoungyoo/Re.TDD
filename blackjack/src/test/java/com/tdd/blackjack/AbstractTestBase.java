package com.tdd.blackjack;

import com.tdd.blackjack.Game;
import com.tdd.blackjack.model.card.Card;
import com.tdd.blackjack.model.card.Deck;
import com.tdd.blackjack.model.card.Rank;
import com.tdd.blackjack.model.card.Shape;
import com.tdd.blackjack.model.person.Dealer;
import com.tdd.blackjack.model.person.Player;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AbstractTestBase {

    protected Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = this.of();
        deck.shuffle();

        assertThat(deck).isNotNull();
        assertThat(deck.size()).isEqualTo(52);
    }

    protected Game ofGame(){
        Game game = new Game();
//        game.initialization(this.of(), new Dealer(), new Player());
        return game;
    }

    protected Deck of() {
        deck = new Deck();
        Stack<Card> cards = deck.create();
        return new Deck(cards);
    }
    protected Dealer ofDealer() {
        return new Dealer();
    }
    protected Player ofPlayer() {
        return new Player();
    }


    protected List<Card> ofCards(Card... cards){
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            result.add(card);
        }
         return result;
    }

    /***
     * 카드 만들기
     * @param shape
     * @param rank
     * @return
     */
    protected Card ofCard(Shape shape, Rank rank){
        return new Card(shape, rank);
    }

    /***
     * 카드 2개
     */



}
