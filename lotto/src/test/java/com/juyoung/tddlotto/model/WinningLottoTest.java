package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.List;

import static com.juyoung.tddlotto.model.LottoTest.ofLotto;
import static com.juyoung.tddlotto.model.LottoTest.ofLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 당첨번호를_생성한다() {
        WinningLotto lottoWinning = new WinningLotto(ofLotto(1,2,3,4,5,6), Number.of(7));
        assertThat(lottoWinning.getBonus()).isNotNull();
    }

    @Test
    public void 당첨번호와_해당로또번호와_보너스가_있는지() {
        WinningLotto lottoWinning = ofLottoWinning(ofLotto(1, 2, 3, 4, 7, 9), 10);
        List<Number> compareLotto = ofLottoNumbers(1, 2, 3, 4, 7, 10);

        boolean result = lottoWinning.containsBonus(compareLotto);
        assertThat(result).isTrue();
    }

    @Test
    public void 로또번호_모두_일치() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        WinningLotto lottoWinning = ofLottoWinning(ofLotto(1, 2, 3, 4, 5, 6), 10);

        Prize result = lottoWinning.result(lotto);

        assertThat(result).isEqualTo(Prize.FIRST);
    }

    @Test
    public void 로또번호_5개일치_보너스일치_2등() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        WinningLotto lottoWinning = ofLottoWinning(ofLotto(1, 2, 3, 4, 5, 9), 6);

        Prize result = lottoWinning.result(lotto);

        assertThat(result).isEqualTo(Prize.SECOND);
    }

    @Test
    public void 로또번호_5개일치_3등() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        WinningLotto lottoWinning = ofLottoWinning(ofLotto(1, 2, 3, 4, 5, 9), 7);

        Prize result = lottoWinning.result(lotto);

        assertThat(result).isEqualTo(Prize.THIRD);
    }

    public static WinningLotto ofLottoWinning(Lotto lotto,
                                              int bonus) {
        return new WinningLotto(lotto, Number.of(bonus));
    }
}