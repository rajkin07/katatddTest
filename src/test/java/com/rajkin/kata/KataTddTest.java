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

}
