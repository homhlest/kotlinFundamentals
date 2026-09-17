package com.example.cli

import com.google.gson.Gson

fun main() {
    val gsonTest = Gson()
    val json = """
        { 
        "name": "John",
        "age": 20
        }
        """.trimIndent()
    val person1 = gsonTest.fromJson(json, User:: class.java)
    println("From json to object: $person1")

    val person2 = gsonTest.toJson(person1)
    println("From object to json: $person2")
}

data class User (val name: String, val age: Int) {
}