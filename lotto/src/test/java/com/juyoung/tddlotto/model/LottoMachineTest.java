package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 로또티켓을_1장_구매한다() {
        LottoMachine machine = new LottoMachine();
        LottoTicket ticket = machine.buy(Wallet.of(5000), 1);
        assertThat(ticket).isNotNull();
    }

}