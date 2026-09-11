package com.example.cli

fun main() {
    //val array = Array(5) {i -> i * i}
    //println(array.contentToString())
    //for (i in array.indices) {
        //println(array[i])
    //}

    // Масив з примітивів
    //val secondArrayInt = IntArray(8) {it}
    //println("Second array: ${secondArrayInt.contentToString()}")

    // Багатовимірний масив-1
    val gameField: Array<Array<Int>> = Array(4) {
        row -> Array(4) {col -> row * 4 + col}
    }
    //println(gameField.contentDeepToString())

//    for(row in gameField) {
//        for (cell in row) {
//            print("$cell \t")
//        }
//        println()
//    }

    // Багатовимірний масив-2
//    var ix = 0
//    val gameField2: Array<Array<Int>> = Array(4) {
//            Array(4) {ix++}
//    }
    //println(gameField2.contentDeepToString())

//    for(row in gameField2) {
//        for (cell in row) {
//            print("$cell \t")
//        }
//        println()
//    }

    val randomNumber = (1..16).random()
    println("Random: $randomNumber")


}