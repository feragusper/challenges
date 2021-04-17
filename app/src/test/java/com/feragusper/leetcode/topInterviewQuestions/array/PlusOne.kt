package com.feragusper.leetcode.topInterviewQuestions.array

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
 */
class PlusOne {

    @Test
    fun testChallenge1() {
        Assert.assertArrayEquals(
            intArrayOf(1, 2, 4),
            plusOne(intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun testChallenge2() {
        Assert.assertArrayEquals(
            intArrayOf(4, 3, 2, 2),
            plusOne(intArrayOf(4, 3, 2, 1))
        )
    }

    @Test
    fun testChallenge3() {
        Assert.assertArrayEquals(
            intArrayOf(1),
            plusOne(intArrayOf(0))
        )
    }

    @Test
    fun testChallenge4() {
        Assert.assertArrayEquals(
            intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1),
            plusOne(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
        )
    }

    @Test
    fun testChallenge5() {
        Assert.assertArrayEquals(
            intArrayOf(
                7,
                2,
                8,
                5,
                0,
                9,
                1,
                2,
                9,
                5,
                3,
                6,
                6,
                7,
                3,
                2,
                8,
                4,
                3,
                7,
                9,
                5,
                7,
                7,
                4,
                7,
                4,
                9,
                4,
                7,
                0,
                1,
                1,
                1,
                7,
                4,
                0,
                0,
                6
            ),
            plusOne(
                intArrayOf(
                    7,
                    2,
                    8,
                    5,
                    0,
                    9,
                    1,
                    2,
                    9,
                    5,
                    3,
                    6,
                    6,
                    7,
                    3,
                    2,
                    8,
                    4,
                    3,
                    7,
                    9,
                    5,
                    7,
                    7,
                    4,
                    7,
                    4,
                    9,
                    4,
                    7,
                    0,
                    1,
                    1,
                    1,
                    7,
                    4,
                    0,
                    0,
                    6
                )
            )
        )
    }

//    fun plusOne(digits: IntArray): IntArray {
//        val numberString = StringBuilder("")
//        digits.forEach {
//            numberString.append(it.toString())
//        }
//
//        val numberPlusOne = numberString.toString().toLong() + 1
//
//        val result = mutableListOf<Int>()
//        numberPlusOne.toString().forEach { numberPlusOneDigit ->
//            result.add(numberPlusOneDigit.toString().toInt())
//        }
//
//        return result.toIntArray()
//    }

    fun plusOne(digits: IntArray): IntArray {
        val digitsPlusOne = digits.toMutableList()
        var carry = false
        for (i in digits.size - 1 downTo 0) {
            val digit = digits[i]
            if (digit != 9) {
                digitsPlusOne[i] = digit + 1
                carry = false
                break
            } else {
                digitsPlusOne[i] = 0
                carry = true
            }
        }

        val result = mutableListOf<Int>()
        if (carry) {
            result.add(1)
            result.addAll(digitsPlusOne)
        } else {
            result.addAll(digitsPlusOne)
        }
        return result.toIntArray()
    }
}