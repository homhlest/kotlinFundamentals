package com.example.cli

import java.util.Collections
import kotlin.collections.indices

/*This is a stripped-down version of the 15-puzzle game.
For the tests it uses 2X2 game board.
It does not validate whether the correct number is entered.*/

const val GAME_BOARD_SIZE_MVC = 2

fun main(){
    var model = createModelGameBoard()
    //println("Модел після створення: $model")
    var view = createViewOfGameBoard(model)
    outputViewOfGameBoard(view)
    while (true) {
        model = moveMVC(model, userInputMVC())
        //println("Модел після ходу: $model")
        view = createViewOfGameBoard(model)
        //println("Вид: ${view.contentDeepToString()}")
        outputViewOfGameBoard(view)
        if (gameIsOverMVC(model)) {
            break
        }

    }
}

fun createModelGameBoard(): MutableList<Int> {
    val modelGameBoard = MutableList(GAME_BOARD_SIZE_MVC*GAME_BOARD_SIZE_MVC) {0}
    for (ix in modelGameBoard.indices) {
        while (true) {
            val randomNumberMVC = (1..(GAME_BOARD_SIZE_MVC * GAME_BOARD_SIZE_MVC)).random()
            if(!modelGameBoard.contains(randomNumberMVC)) {
                modelGameBoard[ix] = randomNumberMVC
                break
            }
        }
    }
    return modelGameBoard
}

fun createViewOfGameBoard(modelGameBoard: MutableList<Int>): Array<Array<Int>>  {
    val view = Array(GAME_BOARD_SIZE_MVC){ Array(GAME_BOARD_SIZE_MVC) {0} }
    var ix = 0
    for (i in view.indices) {
        for (j in view[i].indices) {
            view[i][j] = modelGameBoard[ix]
            ix++
        }

    }
    return view
}

fun outputViewOfGameBoard(view: Array<Array<Int>>) {
    println("=".repeat(GAME_BOARD_SIZE_MVC*GAME_BOARD_SIZE_MVC))
    val temp = Array(GAME_BOARD_SIZE_MVC){Array(GAME_BOARD_SIZE_MVC){"X"}}
    for (i in view.indices) {
        for (j in view.indices) {
            temp[i][j] = view[i][j].toString()
            if(view[i][j] == GAME_BOARD_SIZE_MVC*GAME_BOARD_SIZE_MVC) {
                temp[i][j] = " "
            }
            print("${temp[i][j]} \t")
        }
        println()
    }
    println("=".repeat(GAME_BOARD_SIZE_MVC*GAME_BOARD_SIZE_MVC))
}

// Reading user input.
fun userInputMVC(): Int {
    println("Please, enter a number you wish to move:")
    val userInput = readln().toInt()
    return userInput
}

fun moveMVC(modelGameBoard: MutableList<Int>, userInput: Int): MutableList<Int> {
    Collections.swap(modelGameBoard, modelGameBoard.lastIndexOf(userInput),
        modelGameBoard.lastIndexOf(GAME_BOARD_SIZE_MVC*GAME_BOARD_SIZE_MVC))
    return modelGameBoard
}

//fun gameIsOverMVC(modelGameBoard: MutableList<Int>): Boolean {
//    val controlList = List(GAME_BOARD_SIZE_MVC*GAME_BOARD_SIZE_MVC) {it + 1}
//    println("You win!")
//    return modelGameBoard == controlList
//}

fun gameIsOverMVC(modelGameBoard: MutableList<Int>): Boolean {
    var controlNumber = 1
    for (it in modelGameBoard) {
        if (it != controlNumber++) {
            return false
        }
    }
    println("You win!")
    return true
}