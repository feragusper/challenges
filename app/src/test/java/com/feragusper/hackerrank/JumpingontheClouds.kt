package com.feragusper.hackerrank

import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var jumps = 0

    var currentCloud = 0
    for (i in c.indices) {
        if (currentCloud != i) {
            continue
        }
        if (i < c.size - 1) {
            currentCloud = if (c.size > i + 2 && c[i + 2] == 0) {
                i + 2
            } else {
                i + 1
            }
            jumps++
        }
    }

    return jumps
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
