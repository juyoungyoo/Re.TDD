package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {


    // 로또를 랜덤으로 생성했을 때, 틀리다면 exception
    // 아니면 다시 뽑기
    // 위 조건데 맞는 6자리 로또를 생성한다.
    //

    @Test
    public void 랜덤한_6개의_숫자를_생성한다() {
        int expected = 6;

        Lotto lotto = LottoMachine.createLotto();
        assertThat(lotto.size()).isEqualTo(expected);
    }





//    public Lotto ofLotto(int... numbers){
//        return new Lotto(Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(toList()));
//    }
}