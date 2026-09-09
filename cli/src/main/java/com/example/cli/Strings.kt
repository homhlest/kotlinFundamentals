package com.example.cli

/*This is a heavily stripped down version of the calculator.
It works just with digits: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
Has just four operations: +, -, *, /.
There is no division by zero check.
*/

fun main() {
    calculateResult(collectExpressionMembers())
}

// The function collects all members of the expression into a list.
fun collectExpressionMembers (): List<String> {
    println("Please, input first number.")
    val firstOperand = getUserInput()
    println("Please, input second number.")
    val secondOperand = getUserInput()
    println("Please, input operator.")
    val operator = getUserInput()
    val expressionMembers = listOf(firstOperand, secondOperand, operator)
    return expressionMembers
}

// The function asks for input until the input is valid.
fun getUserInput (): String {
    var userInput = readln()
    while (true) {
        systemFeedback(userInput)
        if (inputIsCorrect(userInput)) break
        userInput = readln()
    }
    return userInput
}

// The function notifies the user about incorrect input. And outputs the feedback to the console.
fun systemFeedback (userInput: String) {
    if (inputIsCorrect(userInput)) return
    println("Input is not correct.")
}

// The function checks whether the input was correct.
fun inputIsCorrect (userInput: String): Boolean {
    return (userInput.length == 1 && (userInput in "1234567890" || userInput in "+-*/"))
}

// The function Checking for division by zero.
fun zeroDivision (operand: String, operator: String): Boolean  {
    return ((operand == "0") && (operator == "/"))
}

// The function is responsible for calculating the results. And outputs the results to the console.
fun calculateResult (expressionMembers: List<String>) {
    if (zeroDivision(expressionMembers[1], expressionMembers[2])) {
        println("Division by zero is undefined.")
        return
    }
    print("Result: ")
    val result = when (expressionMembers[2]) {
        "+" -> expressionMembers[0].toDouble() + expressionMembers[1].toDouble()
        "-" -> expressionMembers[0].toDouble() - expressionMembers[1].toDouble()
        "*" -> expressionMembers[0].toDouble() * expressionMembers[1].toDouble()
        "/" -> expressionMembers[0].toDouble() / expressionMembers[1].toDouble()
        else -> println(0)
    }
}