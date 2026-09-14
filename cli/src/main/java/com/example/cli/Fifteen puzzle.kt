package com.example.cli

import kotlin.collections.indices

fun main() {
    val field = createGameField()
    printGameField(field)
    while (true) {
        moveCellOnTheField(field, userInput())
        printGameField(field)
        if(gameIsOver(field)) break
    }
}

// Outputting the game board in the console.
fun printGameField(gameField: Array<Array<String>>) {
    println("-".repeat(14))
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            print("${gameField[i][j]} \t")
        }
        println()
    }
    println("-".repeat(14))
}

// Creating a two-dimensional array.
fun createGameField(): Array<Array<String>> {
    val gameField = Array(4) { Array(4) {"0"} }
    addRandomNumbersOnTheField(gameField)
    addEmptyCellInGameField(gameField)
    return gameField
}

// Adding unique numbers from 1 to 15 to the game board.
fun addRandomNumbersOnTheField(gameField: Array<Array<String>>): Array<Array<String>> {
    for(i in gameField.indices) {
        for (j in gameField[i].indices) {
            while (true) {
                val randomNumber = (1..16).random()
                if (numberUniq(gameField, randomNumber)) {
                    gameField[i][j] = randomNumber.toString()
                    break
                }
            }
        }
    }
    return gameField
}


// Adding an empty cell to the game board
fun addEmptyCellInGameField (gameField: Array<Array<String>>): Array<Array<String>> {
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            if (gameField[i][j] == "16") {
                gameField[i][j] = " "
            }
        }
    }
    return gameField
}


// Checking the uniqueness of added numbers.
// To ensure the random generator does not add identical numbers to the game board.
fun numberUniq (gameField: Array<Array<String>>, randomNumber: Int): Boolean {
    val numberList = mutableListOf<String>()
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            numberList.add(gameField[i][j])
        }
    }
    return !(numberList.contains(randomNumber.toString()))
}

// Reading user input
fun userInput(): Int {
    val message = println("Please, enter a number you wish to move:")
    val userInputCell = readln().toInt()
    return userInputCell
}

// Moving numbers on the game board based on user input.
fun moveCellOnTheField (gameField: Array<Array<String>>, userInputCell: Int): Array<Array<String>> {
    var cell = Pair(0,0) // Coordinates storage
    // Finding the coordinates of a single number that the user needs to move
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            if (gameField[i][j] == userInputCell.toString()) {
                cell = Pair(i,j)
            }
        }
    }
    // Replace empty cell with user number
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            if (gameField[i][j] == " ") {
                gameField[i][j] = userInputCell.toString()
            }
        }
    }
    // Replace user number with empty cell
    gameField[cell.first][cell.second] = " "
    return gameField
}

// Checking if the game is not over (all numbers in the array are sorted in ascending order).
fun gameIsOver(gameField: Array<Array<String>>): Boolean {
    val controlGameField = Array(4) { Array(4) { "0" } }
    var ix = 1
    for (i in controlGameField.indices) {
        for (j in controlGameField.indices) {
            controlGameField[i][j] = ix++.toString()
        }
    }
    controlGameField[3][3] = " " // The last cell in the bottom right corner
    return gameField.contentEquals(controlGameField)
}
