package com.this_is_java.chapter13_generic;

public class Util {

    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }
}
