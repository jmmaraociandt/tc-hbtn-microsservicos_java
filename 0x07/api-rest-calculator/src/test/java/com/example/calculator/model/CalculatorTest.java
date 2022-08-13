package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeEach
    void calculatorInit() {
        calculator = new Calculator();
    }
    @Test
    void sumTest() {
        assertEquals(5.5, calculator.sum(2.3, 3.2));
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 2.1));
    }


    @Test
    void subTest() {
        assertEquals(10.0, calculator.sub(21.0, 11.0));
    }

    @Test
    void divideTest() {
        assertEquals(5.0, calculator.divide(25.0, 5.0));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(720, calculator.factorial(6));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(111, calculator.integerToBinary(7));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("a", calculator.integerToHexadecimal(10));
    }

    @Test
    void calculeDayBetweenDateTest() {
        assertEquals(14, calculator.calculeDayBetweenDate(
                LocalDate.of(2020, 3, 15),
                LocalDate.of(2020, 3, 29)));
    }
}