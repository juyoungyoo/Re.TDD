package com.juyoung.tddlotto.model;

public enum Prize {

    FIRST(6,100000),
    SECOND(5,10000),
    THIRD(4,1000),
    FOURTH(3,100),
    FIFTH(2,10),
    NONE(1,0);

    private int isMatchCount;
    private int money;

    Prize(int isMatchCount, int money) {
        this.isMatchCount = isMatchCount;
        this.money = money;
    }

    public int getIsMatchCount() {
        return isMatchCount;
    }

    public int getMoney() {
        return money;
    }
}
