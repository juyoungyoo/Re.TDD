package com.tdd.blackjack.model.card;

import com.tdd.blackjack.AbstractTestBase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest extends AbstractTestBase {

    @Test
    public void deckCreate(){
        deck = this.of();
        assertThat(deck).isNotNull();
        assertThat(deck.size()).isEqualTo(52);
    }

    @Test
    public void sendOneCard() {
        of();
        int size = deck.size() -1;
        deck.sendCard();
        assertThat(deck.size()).isEqualTo(size);
    }


}
