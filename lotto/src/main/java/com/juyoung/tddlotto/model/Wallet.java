package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Wallet{

    private int balance;

    private Wallet(int balance){
        this.balance = balance;
    }

    public static Wallet of(int money){
        return new Wallet(money);
    }

    public void spend(int spendMoney){
        validateBalance(spendMoney);
        this.balance -= spendMoney;
    }

    private void validateBalance(int money){
        if (this.balance - money < 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.(현재 잔액 :" + this.balance + ")");
        }
    }

    public void incomePrice(LottoResult lottoResult){
        income(lottoResult.getSummary());
    }

    private void income(int money){
        this.balance += money;
    }

    public boolean isNotBalance(){
        if (this.balance > 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return balance == wallet.balance;
    }

    @Override
    public int hashCode(){
        return Objects.hash(balance);
    }
}
