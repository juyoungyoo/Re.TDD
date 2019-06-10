package com.this_is_java.chapter16_stream;

class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name,
                   int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.getScore());
    }
}
