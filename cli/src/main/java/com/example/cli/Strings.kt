package com.example.cli

/*This is a heavily stripped down version of the calculator.
Just four operations are available here.
There is no division by zero check.
*/

fun main() {
    // Get user input
    println("Please, input first number.")
    val firstOperand = getUserInput()
    println("Please, input second number.")
    val secondOperand = getUserInput()
    println("Please, input operator.")
    val operator = getUserInput()
    // Calculate
    calculateResult(firstOperand, secondOperand, operator)
}

// Get user input
fun getUserInput (): String {
    var userInput = readln() // Get user input
    while (true) {
        systemFeedback(userInput)
        if (inputIsCorrect(userInput)) break
        userInput = readln()
    }
    return userInput
}

// System feedback
fun systemFeedback (userInput: String) {
    if (inputIsCorrect(userInput)) return
    println("Input is not correct.")
}

// User input checking
fun inputIsCorrect (userInput: String): Boolean {
    return (userInput.length == 1 && (userInput in "1234567890" || userInput in "+-*/"))
}

// Calculations
fun calculateResult (firstOperand: String, secondOperand: String, operator: String) {
    println(when (operator) {
        "+" -> firstOperand.toDouble() + secondOperand.toDouble()
        "-" -> firstOperand.toDouble() - secondOperand.toDouble()
        "*" -> firstOperand.toDouble() * secondOperand.toDouble()
        "/" -> firstOperand.toDouble() / secondOperand.toDouble()
        else -> println("No result")
    })
}