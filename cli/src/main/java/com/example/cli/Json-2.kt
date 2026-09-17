package com.example.cli

import com.google.gson.Gson

fun main() {
    println("Simple Task. JSON")
    val gson = Gson()
    val jsonString = gson.toJson(MyModel(1,"Test"))
    println(jsonString)
}

data class MyModel(val id: Int, val description: String)