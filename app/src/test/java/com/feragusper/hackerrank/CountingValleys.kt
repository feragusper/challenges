package com.feragusper.hackerrank

/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

fun countingValleys(steps: Int, path: String): Int {
    var currentLevel = 0
    var valleysCount = 0
    var inAValley = false

    for (i in 0 until steps) {
        if (path[i].toString().toLowerCase() == "u") {
            currentLevel++
        } else {
            currentLevel--
        }

        if (currentLevel < 0) {
            if (inAValley.not()) {
                inAValley = true
                valleysCount++
            }
        } else {
            inAValley = false
        }
    }

    return valleysCount
}

fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}
