package com.example.mycalculatorkotlin

import org.junit.Assert.*

import org.junit.Test

class CalculatorTest {
    @Test
    fun operatorlessStatementShouldReturnTheOperand() {
        //given
        val statement = "128"
        val expected = "128"
        val calculator = Calculator()

        //when
        val actual = calculator.calculate(statement)

        //then
        assertEquals(expected, actual)
    }

    @Test
    fun sumStatementWithTwoOperatorsShouldReturnCorrectResult() {
        //given
        val statement = "1+1"
        val expected = "2"
        val calculator = Calculator()

        //when
        val actual = calculator.calculate(statement)

        //then
        assertEquals(expected, actual)
    }

    @Test
    fun subStatementWithTwoOperatorsShouldReturnCorrectResult() {
        //given
        val statement = "1-1"
        val expected = "0"
        val calculator = Calculator()

        //when
        val actual = calculator.calculate(statement)

        //then
        assertEquals(expected, actual)
    }
    @Test
    fun multStatementWithTwoOperatorsShouldReturnCorrectResult() {
        //given
        val statement = "2*2"
        val expected = "4"
        val calculator = Calculator()

        //when
        val actual = calculator.calculate(statement)

        //then
        assertEquals(expected, actual)
    }

    @Test
    fun divStatementWithTwoOperatorsShouldReturnCorrectResult() {
        //given
        val statement = "2/1"
        val expected = "2"
        val calculator = Calculator()

        //when
        val actual = calculator.calculate(statement)

        //then
        assertEquals(expected, actual)
    }

    @Test
    fun subStatementNegativeCase() {
        //given
        val statement = "1-15"
        val expected = "14"
        val calculator = Calculator()

        //when
        val actual = calculator.calculate(statement)

        //then
        assertEquals(expected, actual)
    }


    @Test
    fun zeroDivision() {
        //given
        val statement = "1/0"
        val expected = "1"
        val calculator = Calculator()

        //when
        val actual = calculator.calculate(statement)

        //then
        assertEquals(expected, actual)
    }
}