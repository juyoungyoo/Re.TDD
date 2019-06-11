package com.this_is_java.chapter16_stream;

<<<<<<< HEAD
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
=======
class Student implements Comparable<Student>{

    private String name;
    private int score;
>>>>>>> master

    public Student(String name,
                   int score) {
        this.name = name;
        this.score = score;
    }

<<<<<<< HEAD
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

=======
>>>>>>> master
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

<<<<<<< HEAD
    public Sex getSex() {
        return sex;
    }

    public City getCity() {
        return city;
    }

=======
>>>>>>> master
    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.getScore());
    }
}
