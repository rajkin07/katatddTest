package com.rajkin.kata;

import java.util.stream.Stream;

public class KataTdd {

    private String delimiter;
    private String numbers;


    /**
     * Constructor to Initialize delimiter and numbers to compute.
     *
     * @param delimiter
     * @param numbers
     */
    private KataTdd(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    /**
     * Actual method to be called for input.
     *
     * @param text
     * @return
     */
    public static int Add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        return parseInput(text).numberAddition();
    }

    /**
     * Parse the string and perform business logic.
     *
     * @param input String
     * @return
     */
    private static KataTdd parseInput(String input) {
        if (input.startsWith("//")) {
            String[] splitString = input.split("\n", 2);
            return new KataTdd(splitString[0].substring(2), splitString[1]);
        } else {
            return new KataTdd(",|\n", input);
        }
    }

    private int numberAddition() {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            return Stream.of(numbers.split(delimiter))
                    .mapToInt(Integer::parseInt).sum();
        }
    }

}