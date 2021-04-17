package com.feragusper.hackerrank

import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    if (n < s.length) {
        return s.substring(0, n.toInt()).count {
            it.toString() == "a"
        }.toLong()
    } else {
        val count = s.count {
            it.toString() == "a"
        }.toLong()
        val repetitions = n / s.length
        val rest = n % s.length
        var result = count * repetitions
        for (i in 0 until rest.toInt()) {
            if (s[i].toString() == "a") {
                result++
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
