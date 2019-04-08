package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    public void 로또넘버가_모두_일치한다_1등() {
        Result result = ofResult(1, 2, 3, 4, 5, 6);
        assertThat(result.getRank()).isEqualTo(Prize.FIRST.name());
        assertThat(result.getPrize()).isEqualTo(Prize.FIRST.getMoney());
    }

    @Test
    public void 로또번호가_다섯개_일치한다_2등() {
        Result result = ofResult(1, 2, 3, 4, 5, 9);
        assertThat(result.getRank()).isEqualTo(Prize.SECOND.name());
        assertThat(result.getPrize()).isEqualTo(Prize.SECOND.getMoney());
    }

    @Test
    public void 로또번호가_다섯개_일치한다_3등() {
        Result result = ofResult(1, 2, 3, 4, 8, 9);
        assertThat(result.getRank()).isEqualTo(Prize.THIRD.name());
        assertThat(result.getPrize()).isEqualTo(Prize.THIRD.getMoney());
    }

    @Test
    public void 로또번호가_다섯개_일치한다_4등() {
        Result result = ofResult(1, 2, 3, 10, 8, 9);
        assertThat(result.getRank()).isEqualTo(Prize.FOURTH.name());
        assertThat(result.getPrize()).isEqualTo(Prize.FOURTH.getMoney());
    }

    private Result ofResult(int... lottoNumbers) {
        Lotto winLotto = LottoTest.ofLotto(1, 2, 3, 4, 5, 6);
        Lotto buy = LottoTest.ofLotto(lottoNumbers);

        Result result = new Result(winLotto, buy);
        return result;
    }


}
