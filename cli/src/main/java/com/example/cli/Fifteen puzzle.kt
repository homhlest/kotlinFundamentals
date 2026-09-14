package com.example.cli

import kotlin.collections.indices

fun main() {
    val field = createGameField()
    printGameField(field)
    while (true) {
        moveCellOnTheField(field, userInput())
        printGameField(field)
    }
}

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

fun createGameField(): Array<Array<String>> {
    val gameField = Array(4) { Array(4) {"0"} }
    addRandomNumbersOnTheField(gameField)
    addEmptyCellInGameField(gameField)
    return gameField
}

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


// Ver1 with for loop
fun numberUniq (gameField: Array<Array<String>>, randomNumber: Int): Boolean {
    val numberList = mutableListOf<String>()
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            numberList.add(gameField[i][j].toString())
        }
    }
    return !(numberList.contains(randomNumber.toString()))
}

fun userInput(): Int {
    val message = println("Please, enter a number you wish to move:")
    val userInputCell = readln().toInt()
    return userInputCell
}

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