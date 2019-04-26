package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.juyoung.tddlotto.model.LottoTest.ofLotto;
import static com.juyoung.tddlotto.model.WinningLottoTest.ofLottoWinning;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 로또티켓의_당첨내역확인() {
        WinningLotto lottoWinning = ofLottoWinning
                (ofLotto(1, 2, 3, 4, 5, 6), 10);
        List<Lotto> lottos = Arrays.asList(
                ofLotto(1, 2, 3, 4, 5, 6),
                ofLotto(1, 2, 3, 4, 5, 7),
                ofLotto(1, 2, 7, 8, 9, 11)
        );
        LottoTicket lottoTicket = ofLottoTicket(lottos);
        LottoResult result = lottoTicket.result(lottoWinning);

        assertThat(result.getCount()).isEqualTo(2);
        assertThat(result.getSummary()).isEqualTo(Prize.FIRST.getMoney() + Prize.THIRD.getMoney());
    }

    @Test
    public void 로또5개를_가진_로또티켓을_생성한다() {
        LottoTicket ticket = new LottoTicket(5);
        assertThat(ticket.getLottos()).size().isEqualTo(5);
        assertThat(ticket.getLottos()).hasOnlyElementsOfType(Lotto.class);
    }

    private LottoTicket ofLottoTicket(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }
}
