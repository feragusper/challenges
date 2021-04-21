package com.feragusper.hackerrank

import java.util.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var count = 0
    var i = 0
    while (i < arr.size) {
        if (arr[i] == i + 1) {
            i++
            continue
        }
        count++
        val tmp = arr[i]
        arr[i] = arr[tmp - 1]
        arr[tmp - 1] = tmp
        i--
        i++
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}