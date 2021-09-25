package com.example.mycalculatorkotlin

import java.math.BigInteger

class Calculator {

    fun calculate(statement: String): String {
        return when {
            statement.contains("+") -> {
                sum(statement)
            }
            statement.contains("-") -> {
                sub(statement)
            }
            statement.contains("*") -> {
                mult(statement)
            }
            statement.contains("/") -> {
                div(statement)
            }
            else -> statement
        }
    }

    private fun sum(statement: String): String{
        val (op1, op2) = statement.split("+")
        return "${BigInteger(op1) + BigInteger(op2)}"
    }

    private fun sub(statement: String): String{
        val (op1, op2) = statement.split("-")
        return "${(BigInteger(op1) - BigInteger(op2)).abs()}"
    }

    private fun mult(statement: String): String{
        val (op1, op2) = statement.split("*")
        return "${BigInteger(op1) * BigInteger(op2)}"
    }

    private fun div(statement: String): String{
        val (op1, op2) = statement.split("/")
        val intOp1 = BigInteger(op1)
        var intOp2 = BigInteger(op2)
        if(intOp2 == BigInteger.ZERO) intOp2 = BigInteger.ONE // handle zero division
        return "${intOp1 / intOp2}"
    }
}