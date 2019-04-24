package com.juyoung.tddlotto.model.lotto;

import com.juyoung.tddlotto.model.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.juyoung.tddlotto.model.lotto.LottoTest.ofLotto;
import static com.juyoung.tddlotto.model.lotto.LottoWinningTest.ofLottoWinning;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void $로또티켓의_당첨내역확인() {
        WinningLotto lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 5, 6}, 10);
        List<Lotto> lottos = Arrays.asList(
                ofLotto(1, 2, 3, 4, 5, 6),
                ofLotto(1, 2, 3, 4, 5, 7),
                ofLotto(1, 2, 7, 8, 9, 11)
        );
        LottoTicket lottoTicket = ofLottoTicket(lottos);
        LottoResult result = lottoTicket.result(lottoWinning);

        assertThat(result.getCount()).isEqualTo(2);
        assertThat(result.getSummary()).isEqualTo(Prize.FIRST.getMoney() + Prize.SECOND.getMoney());
    }

    @Test
    public void $5개의_로또를_생성하여_반환한다() {
        LottoTicket ticket = LottoTicket.of();
        assertThat(ticket.getLottos()).size().isEqualTo(5);
        assertThat(ticket.getLottos()).hasOnlyElementsOfType(Lotto.class);
    }

    private LottoTicket ofLottoTicket(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }
}