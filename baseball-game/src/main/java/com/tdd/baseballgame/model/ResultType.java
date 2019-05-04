package com.tdd.baseballgame.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ResultType {
    STRIKE(true, true),
    BALL(true, false),
    OUT(false, false);

    private boolean isContainNumber;
    private boolean isMatchLocation;

    ResultType(boolean isContainNumber,
               boolean isMatchLocation) {
        this.isContainNumber = isContainNumber;
        this.isMatchLocation = isMatchLocation;
    }


    public static ResultType of(boolean isContainNumber,
                                boolean isMatchLocation) {
        return Arrays.stream(ResultType.values())
                .filter(type -> type.isResultCondition(isContainNumber, isMatchLocation))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    private boolean isResultCondition(boolean isContainNumber,
                                      boolean isMatchLocation) {
        return this.isMatchLocation == isMatchLocation && this.isContainNumber == isContainNumber;
    }
}
