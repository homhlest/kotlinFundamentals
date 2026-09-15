package com.example.cli

import kotlin.collections.indices

/*This is a stripped-down version of the 15-puzzle game.
For the tests it uses 2X2 game board.
It does not validate whether the correct number is entered.*/

const val GAME_BOARD_SIZE = 2
const val EMPTY_CELL_DESIGN = "\u25A1"

fun main() {
    val field = createGameField()
    printGameField(field)
    while (true) {
        move(field, userInput())
        printGameField(field)
        if(gameIsOver(field)) {
            println("You win!")
            break
        }
    }
}

// Creating a two-dimensional array.
fun createGameField(): Array<Array<String>> {
    val gameField = Array(GAME_BOARD_SIZE) { Array(GAME_BOARD_SIZE) {"0"} }
    addNumbersOnTheField(gameField)
    return gameField
}

// Adding unique numbers from to the game board.
fun addNumbersOnTheField(gameField: Array<Array<String>>): Array<Array<String>> {
    for(i in gameField.indices) {
        for (j in gameField[i].indices) {
            while (true) {
                val randomNumber = (1..4).random()
                if (numberIsUniq(gameField, randomNumber)) {
                    gameField[i][j] = randomNumber.toString()
                    break
                }
            }
        }
    }
    addEmptyCellOnGameField(gameField)
    return gameField
}

// Adding an empty cell to the game board
fun addEmptyCellOnGameField (gameField: Array<Array<String>>): Array<Array<String>> {
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            if (gameField[i][j] == "4") {
                gameField[i][j] = EMPTY_CELL_DESIGN // White Square in Unicode
            }
        }
    }
    return gameField
}

// Outputting the game board in the console.
fun printGameField(gameField: Array<Array<String>>) {
    println("=".repeat(5))
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            print("${gameField[i][j]} \t")
        }
        println()
    }
    println("=".repeat(5))
}

// Checking the uniqueness of added numbers. To ensure the random
// generator does not add identical numbers to the game board.
fun numberIsUniq (gameField: Array<Array<String>>, randomNumber: Int): Boolean {
    val numberList = mutableListOf<String>()
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            numberList.add(gameField[i][j])
        }
    }
    return !(numberList.contains(randomNumber.toString()))
}

// Reading user input.
fun userInput(): Int {
    println("Please, enter a number you wish to move:")
    val userInputCell = readln().toInt()
    return userInputCell
}

// Moving numbers on the game board based on user input.
fun move (gameField: Array<Array<String>>, userInputCell: Int): Array<Array<String>> {
    var cell = Pair(0,0) // Coordinates storage
    // Finding the coordinates of a single number that the user needs to move.
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            if (gameField[i][j] == userInputCell.toString()) {
                cell = Pair(i,j)
            }
        }
    }
    // Replace empty cell with user number.
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            if (gameField[i][j] == EMPTY_CELL_DESIGN) {
                gameField[i][j] = userInputCell.toString()
            }
        }
    }
    gameField[cell.first][cell.second] = EMPTY_CELL_DESIGN // Replace user number with empty cell.
    return gameField
}

fun gameIsOver(gameField: Array<Array<String>>): Boolean {
    val controlFieldNumbers = mutableListOf("1", "2", "3", EMPTY_CELL_DESIGN)
    val currentFieldNumbers = mutableListOf<String>()
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            currentFieldNumbers.add(gameField[i][j])
        }
    }
    return controlFieldNumbers == currentFieldNumbers
}
