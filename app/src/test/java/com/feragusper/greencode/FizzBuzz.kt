package com.feragusper.greencode

import org.junit.Test

/**
 * "Write a program that prints the numbers from 1 to 100.
 * But for multiples of 3 print “Fizz” instead of the number and for the multiples of 5 print “Buzz”.
 * For numbers which are multiples of both 3 and 5 print “FizzBuzz”."
 */
class FizzBuzz {

    @Test
    fun testChallenge1() {
        fizzBuzz()
    }

    fun fizzBuzz() {
        for (i in 1..100) {
            var result = ""

            if (i % 3 == 0) {
                result = "Fizz"
            }

            if (i % 5 == 0) {
                result += "Buzz"
            }

            println(if (result.isEmpty()) i else result)
        }
    }

}