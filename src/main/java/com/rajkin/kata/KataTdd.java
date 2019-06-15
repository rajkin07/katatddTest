package com.rajkin.kata;

import java.util.Arrays;
import java.util.stream.Stream;

public class KataTdd {

    public static int Add(String text) {
        String delimiter = ",|\n";
        if (text.startsWith("//")) {
            String[] splitString = text.split("\n", 2);
            delimiter = splitString[0].substring(2);
            text = splitString[1];
        }

        if (text.isEmpty()) {
            return 0;
        }

        Stream<String> numbersToSum = Arrays.stream(text.split(delimiter));
        return numbersToSum.mapToInt(Integer::parseInt).sum();
    }

}