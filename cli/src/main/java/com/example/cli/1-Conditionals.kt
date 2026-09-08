package com.example.cli

fun main() {
    var a = 12
    var b = 22

    // Блок із стандартним іфом
    if (a > 11) {
        println("A > 11")
        b--
        }
    else {
        println("A < 11")
    }
    println("Змінна B = $b")

    // Це щось типу тернарного джави, але по котліну
    val c = if (a > b) a else b
    println("Змінна С = $c")

    // Блок з присвоєнням змінної одразу (має бути зручна штука)
    val d = if (a > b) {
        println("Змінна D = $a")
        a
    }
    else {
        println("Змінна D = $b")
        b
    }

    // Блок з When фактично замінює іф елс

    // When без сабджекта (фактична як інструкція, тому значення не повертає
    // і відповідно, не потрібен else в кінці
    when {
        a == 12 -> println("When без сабджекта: А = 12")
        a == 10 -> println("When без сабджекта: А = 10")
        a == 9 -> println("When без сабджекта: А = 09")
    }

    // When із сабджектом
    when (a) {
        12 -> println("When з сабджектом: А = 12")
        10 -> println("When з сабджектом: А = 10")
        9 -> println("When з сабджектом: А = 09")
    }

    // When із сабджектом з переліком
    when (a) {
        10, 20, 30 -> println("A не входить у перелік")
        12 -> println("А у переліку")

    }

    // When із сабджектом з діапазоном
    when (a) {
        in 10..20 -> println("А входить в діапазон")
    }

    // When як експрешн
    val res = when (a) {
        in 10..20 -> 10
        else -> "Значення змінної невідоме"
    }
    println(res)

    // When з принтом
    val resultWithPrint =
        if (a > b) "resultWithPrint = $a"
        else "Немає рузультату - тут елс спрацювало"
    println(resultWithPrint) // виводимо текст

    // Hyperskills
    println(if (false) "A" else "B")
}