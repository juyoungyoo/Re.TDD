package com.juyoung.tddlotto.model.lotto;


import com.juyoung.tddlotto.model.Prize;
import com.juyoung.tddlotto.model.ball.LottoNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.juyoung.tddlotto.model.lotto.LottoWinningTest.ofLottoWinning;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또는_6개의_로또넘버를_생성한다() {
        Lotto lotto = Lotto.of();
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_7개_이상일때_실패한다() {
        ofLotto(1, 2, 3, 4, 5, 6, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_6개_미만일때_실패한다() {
        ofLotto(1, 2, 3, 4, 5);
    }


    @Test
    public void 로또번호_모두_일치() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        LottoWinning lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 5, 6}, 10);

        Prize result = lotto.result(lottoWinning);

        assertThat(result).isEqualTo(Prize.FIRST);
    }

    @Test
    public void $2등_로또번호_5개_일치() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        LottoWinning lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 5, 9}, 10);

        Prize result = lotto.result(lottoWinning);

        assertThat(result).isEqualTo(Prize.SECOND);
    }

    @Test
    public void $3등_로또번호_5개_일치_보너스_포함() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        LottoWinning lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 7, 9}, 6);

        Prize result = lotto.result(lottoWinning);

        assertThat(result).isEqualTo(Prize.THIRD);
    }

    public static Lotto ofLotto(int... lottoNumbers) {
        List<LottoNumber> numbers = ofLottoNumbers(lottoNumbers);
        return new Lotto(numbers);
    }

    public static List<LottoNumber> ofLottoNumbers(int... numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::of).collect(Collectors.toList());
    }
}