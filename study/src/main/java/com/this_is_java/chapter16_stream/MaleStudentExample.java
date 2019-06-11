package com.this_is_java.chapter16_stream;

import com.this_is_java.chapter16_stream.Student.Sex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 사용자 정의 컨테이너에 수집
 */
public class MaleStudentExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10, Sex.MALE),
                new Student("김수애", 6, Sex.FEMALE),
                new Student("신용권", 10, Sex.MALE),
                new Student("박수미", 6, Sex.FEMALE)
        );

        // supplier
        Supplier<MaleStudent> supplier = () -> new MaleStudent();
        // accumulator
        BiConsumer<MaleStudent, Student> accumulator = (ms, s) -> ms.accumulate(s);
        // combiner
        BiConsumer<MaleStudent, MaleStudent> combiner = (ms1, ms2) -> ms1.combine(ms2);
        /*
         * @param supplier a function that creates a new result container.
         * @param accumulator function for incorporating an additional element into a result
         * @param combiner    function for combining two values, which must be
         *                    compatible with the accumulator function
            <R> R collect(Supplier<R> supplier,
                BiConsumer<R, ? super T> accumulator,
                BiConsumer<R, R> combiner);
        */
        students.stream()
                .collect(Collectors.toList());

        // 방법 1.
        students.stream()
                .collect(supplier, accumulator, combiner);

        // 방법 2.
        students.stream()
                .filter(s -> s.getSex() == Sex.MALE)
                .collect(
                        ()-> new MaleStudent(),
                        (r, t) -> r.accumulate(t),
                        (r1, r2) -> r1.combine(r2)
                );
        // 방법3. 메소드 참조
        MaleStudent maleStudent = students.stream()
                .filter(s -> s.getSex() == Sex.MALE)
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);
        maleStudent.getList().stream().forEach(student -> System.out.println(student.getName()));
    }

    private static class MaleStudent {

        private List<Student> list;

        public MaleStudent() {
            list = new ArrayList<>();
            System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
        }

        public void accumulate(Student student) {
            list.add(student);
            System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
        }

        public void combine(MaleStudent other) {
            list.addAll(other.getList());
            System.out.println("[" + Thread.currentThread().getName() + "] combine()");
        }

        public List<Student> getList() {
            return list;
        }
    }
}
