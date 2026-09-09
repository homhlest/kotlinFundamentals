package com.example.cli

/*This is a heavily stripped down version of the calculator.
It has just four operations: +, -, *, /.
*/

fun main() {
    calculateResult(getOperandFromUser(),getOperandFromUser(),getOperatorFromUser())
}

// The function asks for number input until the input is valid.
fun getOperandFromUser (): Int {
    var userInput: Int? = null
    while (userInput == null) {
        println("Please, input number.")
        userInput = readln().toIntOrNull()
        if (userInput == null) {
            println("Input is not correct.")
        }
    }
    return userInput
}

// The function asks for operator input until the input is valid.
fun getOperatorFromUser (): String {
    println("Please, input operator.")
    var userInput: String = readln()
    while (operandIsNotCorrect(userInput)){
        println("Input is not correct. Please, input operator: +, -, *, /")
        userInput = readln()
    }
    return userInput
}

// The function checks if the operator input is valid.
fun operandIsNotCorrect (userInput: String): Boolean {
    return userInput.length != 1 || userInput !in "+-*/"
}

// The function checks division by zero.
fun isZeroDivision(operand: Int, operator: String): Boolean {
    return (operand.toString() == "0" && operator == "/")
    }

// The function calculates the result. And outputs the result to the console.
fun calculateResult (operand1: Int, operand2: Int, operator: String) {
    if (isZeroDivision(operand2, operator)) {
        println("Division by zero is undefined. Try another expression.")
        return
    }
    print("$operand1 $operator $operand2 = ")
    val result = when (operator) {
        "+" -> operand1 + operand2
        "-" -> operand1 - operand2
        "*" -> operand1 * operand2
        "/" -> operand1.toDouble() / operand2.toDouble()
        else -> println(0)
    }
    println(result)
}
