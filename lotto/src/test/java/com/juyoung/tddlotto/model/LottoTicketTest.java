package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void $5개의_로또를_생성하여_반환한다() {
        LottoTicket ticket = LottoTicket.of ();
        assertThat(ticket.getLottos()).size().isEqualTo(5);
        assertThat(ticket.getLottos()).hasOnlyElementsOfType(Lotto.class);
    }
}