package com.feragusper.leetcode.topInterviewQuestions.strings

import android.R.attr
import org.junit.Assert
import org.junit.Test


/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0


Constraints:

-231 <= x <= 231 - 1

 */
class ReverseInteger {

    @Test
    fun testChallenge1() {
        Assert.assertEquals(321, reverse(123))
    }

    @Test
    fun testChallenge2() {
        Assert.assertEquals(-123, reverse(-321))
    }

    @Test
    fun testChallenge3() {
        Assert.assertEquals(21, reverse(120))
    }

    @Test
    fun testChallenge4() {
        Assert.assertEquals(0, reverse(0))
    }

    @Test
    fun testChallenge5() {
        Assert.assertEquals(0, reverse(1534236469))
    }

    fun reverse(x: Int): Int {
        var rev = 0
        var xMutable = x
        while (xMutable != 0) {
            val pop = xMutable % 10
            xMutable /= 10
            if (rev > Int.MAX_VALUE / 10 || rev == Int.MAX_VALUE / 10 && pop > 7) return 0
            if (rev < Int.MIN_VALUE / 10 || rev == Int.MIN_VALUE / 10 && pop < -8) return 0
            rev = rev * 10 + pop
        }
        return rev
    }
}