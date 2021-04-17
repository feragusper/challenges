package com.feragusper.hackerrank

import java.util.*

// Complete the rotLeft function below.
fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val result = mutableListOf<Int>()

    val shifts = if (d > a.size) {
        a.size % d
    } else {
        d
    }

    for (i in shifts downTo 0) {
        result.add(a[i])
    }

    for (i in 0 until a.size - shifts) {
        result.add(a[i])
    }

    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
