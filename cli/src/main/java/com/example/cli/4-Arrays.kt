//package com.example.cli
//
fun main() {

    val randomNumber = (0..15).random()
    val controlGameField = Array(4) { Array(4) { "0" } }
    var ix = 1
    for (i in controlGameField.indices) {
        for (j in controlGameField.indices) {
            controlGameField[i][j] = ix++.toString()
            //print("${controlGameField[i][j]} \t")
        }
        //println()
    }
    controlGameField[3][3] = " "

    println(controlGameField.contentDeepToString())

    val controlGameField2 = Array(4) { Array(4) { "0" } }
    var ix2 = 1
    for (i in controlGameField2.indices) {
        for (j in controlGameField2.indices) {
            controlGameField2[i][j] = ix2++.toString()
            //print("${controlGameField2[i][j]} \t")
        }
        //println()
    }
    controlGameField2[3][3] = " "

    println(controlGameField2.contentDeepToString())

    println(controlGameField.contentEquals(controlGameField2))
}





//
//
//
//
//    //val array = Array(5) {i -> i * i}
//    //println(array.contentToString())
//    //for (i in array.indices) {
//        //println(array[i])
//    //}
//
//    // Масив з примітивів
//    //val secondArrayInt = IntArray(8) {it}
//    //println("Second array: ${secondArrayInt.contentToString()}")
//
//    // Багатовимірний масив-1
//    val gameField: Array<Array<Int>> = Array(2) {
//        row -> Array(4) {col -> row * 4 + col}
//    }
//    //println(gameField.contentDeepToString())
//
////    for(row in gameField) {
////        for (cell in row) {
////            print("$cell \t")
////        }
////        println()
////    }
////
////    println("-".repeat(20))
//
//    // Багатовимірний масив-2
//    var ix = 0
//    val gameField2: Array<Array<Int>> = Array(2) {
//            Array(4) {ix++}
//    }
//
//    //println(gameField2.contentDeepToString())
//
////    for(i in gameField2.indices) {
////        for (j in gameField2[i].indices) {
////            print("${gameField2[i][j]} \t")
////            //builder.append(gameField2[i][j])
////        }
////        println()
////    }
//    //println(builder)
//
////    val randomNumber = (1..16).random()
////    println("Random: $randomNumber")
//
//
//}


// Ver2 with extension function any
fun numberUniqVer2(gameField: Array<IntArray>, randomNumber: Int): Boolean {
    return !gameField.any {row -> randomNumber in row}
}

fun gameIsOver2(gameField: Array<Array<String>>): Boolean {
    val controlFieldNumbers = mutableListOf(
        "1", "2", "3", /*"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",*/ " ")
    val currentFieldNumbers = mutableListOf<String>()
    for (i in gameField.indices) {
        for (j in gameField[i].indices) {
            currentFieldNumbers.add(gameField[i][j])
        }
    }
    return controlFieldNumbers == currentFieldNumbers
}