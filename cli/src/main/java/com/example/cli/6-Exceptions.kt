package com.example.cli

import kotlin.collections.get

fun main(){
    val ordinals = listOf("0", "1", "2", "3", "4")
    try {
        println(ordinals.get(10))
    } catch (e: Exception) {
        println("Ось тут щось пішло не так! ${e.message}")
    }
    println(ordinals.get(2))
}