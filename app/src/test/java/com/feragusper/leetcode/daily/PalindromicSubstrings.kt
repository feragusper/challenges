package com.feragusper.leetcode.daily

import org.junit.Assert
import org.junit.Test

/**
 * IT WORKS!
 */
class PalindromicSubstrings {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        Assert.assertEquals(6, countSubstrings("aaa"))
    }

    @Test
    fun testChallenge2() {
        Assert.assertEquals(3, countSubstrings("abc"))
    }

    @Test
    fun testChallenge3() {
    }

    fun countSubstrings2(s: String): Int {
        var result = 0

        var substring = ""
        var substringBackwards = ""
        val checkedRanges = mutableListOf<IntRange>()
        var rangeToCheck: IntRange
        for (i in s.indices) {
            rangeToCheck = IntRange(i, s.length)
            if (checkedRanges.contains(rangeToCheck).not()) {
                substring = s.substring(i)
                substringBackwards = substring.reversed()
                checkedRanges.add(rangeToCheck)
                if (substring == substringBackwards) {
                    result++
                }
            }

            rangeToCheck = IntRange(0, i + 1)
            if (checkedRanges.contains(rangeToCheck).not()) {
                substring = s.substring(0, i + 1)
                substringBackwards = substring.reversed()
                checkedRanges.add(IntRange(0, i + 1))
                if (substring == substringBackwards) {
                    result++
                }
            }
        }

        return result
    }

    fun countSubstrings(s: String): Int {
        var result = 0

        var substring: String
        var substringBackwards: String
        var begin: Int
        var end: Int
        for (i in s.indices) {
            for (j in i until s.length) {
                begin = i
                end = j + 1
                substring = s.substring(begin, end)
                substringBackwards = substring.reversed()
                if (substring == substringBackwards) {
                    result++
                }
            }
        }

        return result
    }
}