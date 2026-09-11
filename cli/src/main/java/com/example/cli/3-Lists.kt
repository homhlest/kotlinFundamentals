package com.example.cli

import java.util.*

fun main(args: Array<String>) {
    // Create a mutable list to store the input numbers
    val numberList = mutableListOf<Int>()

    // Use a scanner to read the user input
    val scanner = Scanner(System.`in`)

    // TODO: Extract the integers from the input and add them to the mutable list

    val tempNumberList = scanner.nextLine().split("\\s+".toRegex()).mapNotNull { it.toIntOrNull() }

    numberList.addAll(tempNumberList)

    println(numberList.joinToString(" "))

    numberList.sort()

    println("Sorted list: ${numberList.joinToString(" ")}")


//    // TODO: Sort the list in ascending order
//    numberList.sorted()
//
//    // TODO: Iterate through the sorted list and print each number followed by a space.
//    println(numberList.joinToString(" "))
}
