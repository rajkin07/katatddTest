package com.rajkin.kata;

import org.junit.Test;

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
        assertEquals(KataTdd.Add("1,2,3,44,5,6,8,9,07,999,1016"), 2100);
    }


}
