package com.juyoung.tddlotto.model;

import com.juyoung.tddlotto.model.lotto.Lotto;
import com.juyoung.tddlotto.model.lotto.LottoTicket;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 로또티켓을_1장_구매한다() {
        LottoMachine machine = new LottoMachine();
        LottoTicket ticket = machine.buy();
        assertThat(ticket).isNotNull();
    }

    public static class LottoTicketTest {

        @Test
        public void $5개의_로또를_생성하여_반환한다() {
            LottoTicket ticket = LottoTicket.of ();
            assertThat(ticket.getLottos()).size().isEqualTo(5);
            assertThat(ticket.getLottos()).hasOnlyElementsOfType(Lotto.class);
        }
    }
}