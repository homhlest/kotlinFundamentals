package com.example.cli

fun main(){
//    val number = 5
//    for (number in 1..5) {
//        print("$number ")
//    }

    // Вкладений цикл
    var cell = 0
    for (i in 1..4) {
        for(j in 1..4) {
            print("$cell \t")
            cell++
        }
        println()
    }
}