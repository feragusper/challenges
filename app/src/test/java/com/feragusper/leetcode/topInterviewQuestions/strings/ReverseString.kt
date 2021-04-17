package com.feragusper.leetcode.topInterviewQuestions.strings

import org.junit.Assert
import org.junit.Test

/**
Write a function that reverses a string. The input string is given as an array of characters s.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.


Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

 */
class ReverseString {

    @Test
    fun testChallenge1() {
        Assert.assertArrayEquals("olleh".toCharArray(), reverseString("hello".toCharArray()))
    }

    @Test
    fun testChallenge2() {
        Assert.assertArrayEquals("hannaH".toCharArray(), reverseString("Hannah".toCharArray()))
    }

    fun reverseString(s: CharArray): CharArray {
        var lastElementNotReplacedYet: Char
        for (i in s.indices) {
            if (s.size - 1 - i <= i) {
                break
            }
            lastElementNotReplacedYet = s[s.size - 1 - i]
            s[s.size - 1 - i] = s[i]
            s[i] = lastElementNotReplacedYet
        }

        return s
    }
}