package com.lambda.api.function;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Student {
    private String name;
    private int englishScore;
    private int mathScore;

    public Student(String name,
                   int englishScore,
                   int mathScore) {
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }
}
