package com.this_is_java.chapter16_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        /*
        // NoSuchElementException 발생
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();*/

        // isPresent() 이용한 exception 처리
        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average();
        double result;
        if(optionalDouble.isPresent()){
            result = optionalDouble.getAsDouble();
        }else{
            result = 0.0;
        }
        System.out.println("result : " + result);

        // orElse 이용한 exception 처리
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("result : " + avg);

        // ifPresent 이용한 exception 처리
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(num -> System.out.println("result: " + num));
    }
}
