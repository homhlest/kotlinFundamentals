package com.example.cli

//fun main () {
//    println(println())
//    hello()
//}

fun main() {
    val letter = readln().firstOrNull()
    if (letter != null) {
        println(letter.isUpperCase() || letter.isDigit())
    } else {
        println(false)
    }
}

fun hello() {
    println("Hello!")
}