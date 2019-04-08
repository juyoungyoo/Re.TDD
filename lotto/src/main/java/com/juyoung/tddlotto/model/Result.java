package com.juyoung.tddlotto.model;

public class Result {

    private String rank;
    private int price;

    public Result(Lotto winLotto, Lotto buy) {
        this.calculatedRank(winLotto, buy);
        this.calculatedPrize(winLotto, buy);
    }

    public void calculatedRank(Lotto winLotto, Lotto other) {
        int matchNumber = getMatchNumber(winLotto, other);
        for (Prize prize : Prize.values()) {
            if(prize.getIsMatchCount() == matchNumber){
                this.rank = prize.name();
            }
        }
    }

    public void calculatedPrize(Lotto winLotto, Lotto other) {
        int matchNumber = getMatchNumber(winLotto, other);
        for (Prize prize : Prize.values()) {
            if(prize.getIsMatchCount() == matchNumber){
                this.price = prize.getMoney();
            }
        }
    }

    private int getMatchNumber(Lotto winLotto, Lotto other) {
        return winLotto.match(other);
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
