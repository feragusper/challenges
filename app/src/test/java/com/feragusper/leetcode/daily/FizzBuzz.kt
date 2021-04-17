package com.feragusper.leetcode.daily

import org.junit.Test

/**
 * IT WORKS!
 */
class FizzBuzz {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        fizzBuzz(15)
    }

    @Test
    fun testChallenge2() {

    }

    @Test
    fun testChallenge3() {
    }


    fun fizzBuzz(n: Int) {
        for (i in 1..n) {
            var print = ""

            if (i % 3 == 0) {
                print = "Fizz"
            }
            if (i % 5 == 0) {
                print += "Buzz"
            }

            if (print.isBlank()) {
                print = i.toString()
            }

            println(print)
        }
    }
}