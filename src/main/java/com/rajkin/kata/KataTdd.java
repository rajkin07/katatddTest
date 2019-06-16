package com.rajkin.kata;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KataTdd {

    public static final int MAX_VALUE = 1000;
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

        return parseInput(text).nonStaticAddtion();
    }

    private int nonStaticAddtion() {
        byforgetNegativeNumbers();
        return numberAddition().sum();
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
            return new KataTdd(delimiterAnyLength(splitString[0]), splitString[1]);
        } else {
            return new KataTdd(",|\n", input);
        }
    }

    /**
     * Refactored Method for Modularisation.
     *
     * @return
     */
    private IntStream numberAddition() {
        if (numbers.isEmpty()) {
            return IntStream.empty();
        } else {
            return Stream.of(numbers.split(delimiter))
                    .mapToInt(Integer::parseInt).filter(n -> n < MAX_VALUE);
        }
    }

    /**
     * Throw exception On negative value and return all negative value in exception message.
     */
    private void byforgetNegativeNumbers() {
        String negativeNumbers = numberAddition().filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negative number: " + negativeNumbers);
        }
    }

    /**
     * Method Allows any no of delimiters.
     * @param line
     * @return
     */
    private static String delimiterAnyLength(String line) {
        String delimiter = line.substring(2);
        if (delimiter.startsWith("[")) {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
        }
        return Pattern.quote(delimiter);
    }




}