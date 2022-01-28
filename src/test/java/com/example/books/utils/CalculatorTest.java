package com.example.books.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {


    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(20, calculator.multiply(4, 5),
                "Regular multiplication should work");
    }

    @Test
    void testMultiplyWithZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
        assertEquals(0, calculator.multiply(5, 0), "Multiple with zero should be zero");
    }
}
