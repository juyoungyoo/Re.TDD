package com.this_is_java.chapter16_stream;

class Student implements Comparable<Student> {

    public enum Sex {
        MALE("남학생"),
        FEMALE("여학생");

        private String ko;

        Sex(String ko) {
            this.ko = ko;
        }

        public String getKo() {
            return ko;
        }
    }
    public enum City {SEOUL, BUSAN}

    private String name;
    private int score;
    private Sex sex;
    private City city;

    public Student(String name,
                   int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name,
                   int score,
                   Sex sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    public Student(String name,
                   int score,
                   Sex sex,
                   City city) {
        this.name = name;
        this.score = score;
        this.sex = sex;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Sex getSex() {
        return sex;
    }

    public City getCity() {
        return city;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.getScore());
    }
}
