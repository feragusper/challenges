package com.feragusper.hackerrank

import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val pairs = mutableListOf<Int>()
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (pairs.contains(i).or(pairs.contains(j))) {
                continue
            }
            if (ar[i] == ar[j]) {
                pairs.add(i)
                pairs.add(j)
            }
        }
    }

    return pairs.size / 2
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}