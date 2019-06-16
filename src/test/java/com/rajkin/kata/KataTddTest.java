package com.rajkin.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class KataTddTest {

    //FirstIteration
    //1.Create a simple String calculator with a method signature.
    @Test
    public void emptyStringReturnZero() {
        assertEquals(KataTdd.Add(""), 0);
    }

    @Test
    public void oneNumber() {
        assertEquals(KataTdd.Add("3"), 3);
    }

    @Test
    public void twoNumbers() {
        assertEquals(KataTdd.Add("7,27"), 34);
    }

    //SecondIteration
    //2.Allow the Add method to handle an unknown amount of numbers.
    @Test
    public void moreDigitsSupporte() {
        assertEquals(KataTdd.Add("22,55,777"), 854);
    }

    @Test
    public void unknownAmountOFNnumersAsInput() {
        assertEquals(KataTdd.Add("1,2,3,44,5,6,8,9,07,999,999,17"), 2100);
    }

    //ThirdIteration
    //3.Allow the Add method to handle new lines between numbers (instead of commas).
    @Test
    public void newlineBetweenNumbers() {
        assertEquals(KataTdd.Add("7\n3"), 10);
    }

    @Test
    public void newLineBetweenNoAndCommaSeparator() {
        assertEquals(KataTdd.Add("7\n1,9"), 17);
    }

    //ForthIteration
    //4.Support different delimiters
    @Test
    public void supportForDelimiterByUser() {
        assertEquals(25, KataTdd.Add("//;\n10;5;3;7"));
    }

    @Test
    public void separatorByUserWithNoNumbersReturnsZero() throws Exception {
        assertEquals(0, KataTdd.Add("//;\n"));
    }

    @Test
    public void separatorWithOnlyOneNumber() throws Exception {
        assertEquals(9, KataTdd.Add("//;\n9"));
    }

    //Modularize Code and Refactoring.

    //FifthIteration
    //5.Calling Add with a negative number will throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void exceptionOnNegativeNumber() {
        KataTdd.Add("-3");
    }

    //component that intercepts test method calls and set exception before and after Method.
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void negativeNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("negative number: -7,-77,-5");

        KataTdd.Add("-7,7,-77,99,-5");
    }

    @Test
    public void negativeNotAllowed2() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("negative number: -7");

        KataTdd.Add("//;\n-7;4");
    }

    //SixthIteration
    //6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
    @Test
    public void ignoreNumbersAbove1000() {
        assertEquals(KataTdd.Add("1002"), 0);
    }

    @Test
    public void ignoreNumbersAbove1000Multipal() {
        assertEquals(KataTdd.Add("40,10002,1077"), 40);
    }

    //SeventhIteration
    //7.Delimiters can be of any length
    @Test
    public void acceptsDelimiterOfAnyLength() {
        assertEquals(KataTdd.Add("//[***]\n7***5***3"), 15);
    }

}
