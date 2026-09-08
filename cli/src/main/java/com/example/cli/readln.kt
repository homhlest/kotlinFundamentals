package com.example.cli

fun main() {
    var userInput = readln().toIntOrNull() ?: "Input is not correct"
    println(userInput)
}