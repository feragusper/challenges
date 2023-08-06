package com.feragusper.coderbyte

import org.junit.Test

/**
 * Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed order.
 * For example: if the input string is "Hello World and Coders" then your program should return the string sredoC dna dlroW olleH.
 */
class FirstReverse {

    @Test
    fun testChallenge() {
        assert(firstReverse("coderbyte") == "etybredoc")

        assert(firstReverse("I Love Code") == "edoC evoL I")
    }

    private fun firstReverse(str: String): String {
        return str.reversed()
    }

}