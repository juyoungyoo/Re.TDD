package com.this_is_java.chapter16_stream;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("java8 lambda", "stream mapping");

        inputList.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));


        System.out.println("==================================================");

        List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        inputList2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(", ");
                    int[] ints = new int[strArr.length];
                    for(int i=0; i<strArr.length; i++){
                        ints[i] = Integer.parseInt(strArr[i]);
                    }
                    return Arrays.stream(ints);
                })
                .forEach(num -> System.out.println(num));

    }
}
