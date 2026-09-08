package com.example.cli

fun main() {
    val name: String? = "Tom" // Позначили знаком ? що тут може бути нал
    // Ось так можна захиститися від нала - елвіс оператор - ?:
    val userNаme: String = name ?: "Невизначено який тут тип"

    // Фактично елвіс оперетор = перевірці на налл в іф
    var firstName: String? = "Alex"
    var secondName: String

    // Ось це:
    if (firstName ==  null) {
        secondName = "N/A"
    } else {
        secondName = firstName
    }

    // Рівноцінне ось цьому:
    secondName = firstName ?: "N/A"

    // Safe виклик робиться з ?
    //val text: String? = "Hello!"
    val text: String? = null // версія з налом. вище рядок - версія без налу
    println("Довжина тексту з налом: ${text?.length ?: "Соррі, там налл"}")

    // Декларейшн налла
    val nullTest1: String? = "Bob"
    //val nullTest2: String = null // помилка
    val nullTest3: String? = null

    var firstNname = null
    val lastName = firstNname
    firstName = "John"
    //println("${firstName?.length} ${lastName?.length}")
}