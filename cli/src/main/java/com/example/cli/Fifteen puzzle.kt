package com.example.cli

fun main() {
    createField()
}

fun createField() {
    var ix = 0
    val gameField: Array<Array<Int>> = Array(4) {
        Array(4) {ix++}
    }
    addRandomNumbers(gameField)
}

fun addRandomNumbers(gameField: Array<Array<Int>> ) {
    var randomNumber: Int
    for(i in gameField.indices) {
        for (j in gameField.indices) {
            randomNumber = (1..16).random()
            if (numberIsUniq(gameField, gameField[i][j])) {
                gameField[i][j] = randomNumber
            } else {
                break
            }
            print("${gameField[i][j]} \t")
        }
        println()
    }
}

fun numberIsUniq (gameField: Array<Array<Int>>, randomNumber: Int): Boolean {
    for (i in gameField.indices) {
        for (j in gameField.indices) {
            if (gameField[i][j] == randomNumber)
                return false
        }
    }
    return true
}