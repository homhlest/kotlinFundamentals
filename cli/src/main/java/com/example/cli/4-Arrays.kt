package com.example.cli

import kotlin.collections.indices

fun main() {
    val myArray = arrayOf(1, 2, 3, 4, 5, 6)
    for (el in myArray) {
        print("$el \t")
    }
    println()
}
