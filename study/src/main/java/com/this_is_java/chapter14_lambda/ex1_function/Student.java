package com.this_is_java.chapter14_lambda.ex1_function;

class Student {
    private final String name;
    private final int englishScore;
    private final int mathScore;

    public Student(String name,
                   int englishScore,
                   int mathScore) {
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public String getName() {
        return name;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }
}
