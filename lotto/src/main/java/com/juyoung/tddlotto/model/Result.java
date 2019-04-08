package com.juyoung.tddlotto.model;

public class Result {

    private String rank;
    private int price;

    public Result(Lotto winLotto,
                  Lotto buy) {
        int matchCount = getMatchNumber(winLotto, buy);
        this.calculatedRank(matchCount);
        this.calculatedPrize(matchCount);
    }

    public void calculatedRank(int matchCount) {
        for (Prize prize : Prize.values()) {
            if (prize.getIsMatchCount() == matchCount) {
                this.rank = prize.name();
            }
        }
    }

    public void calculatedPrize(int matchCount) {
        for (Prize prize : Prize.values()) {
            if (prize.getIsMatchCount() == matchCount) {
                this.price = prize.getMoney();
            }
        }
    }

    private int getMatchNumber(Lotto winLotto,
                               Lotto other) {
        Lotto lotto = new Lotto(winLotto);
        return lotto.match(other);
    }

    public String getRank() {
        return rank;
    }

    public int getPrize() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Result{" +
                "rank='" + this.rank + '\'' +
                ", price=" + this.price +
                '}';
    }
}
