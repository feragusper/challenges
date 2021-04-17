package com.feragusper.hackerrank

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    val hourglassesSums = mutableListOf<Int>()
    var hourglassSum = 0
    for (i in 0..arr.size - 3) {
        for (j in 0..arr[i].size - 3) {
            hourglassSum = 0
            for (k in j..j + 2) {
                hourglassSum += arr[i][k]
                hourglassSum += arr[i + 2][k]
            }
            hourglassSum += arr[i + 1][j + 1]
            hourglassesSums.add(hourglassSum)
        }
    }

    hourglassesSums.sort()

    return hourglassesSums.last()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
