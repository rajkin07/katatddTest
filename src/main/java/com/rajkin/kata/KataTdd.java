package com.rajkin.kata;

import java.util.Arrays;
import java.util.stream.Stream;

public class KataTdd {

    public static int Add(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        Stream<String> numbersToSum = Arrays.stream(text.split(","));
        return numbersToSum.mapToInt(Integer::parseInt).sum();
    }

}