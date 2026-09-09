package com.example.cli

fun main() {
    val usersInput = readln().toIntOrNull() ?: "Input is not correct"
    println(usersInput.toString().length)
    println(usersInput)
}