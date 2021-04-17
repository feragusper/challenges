package com.feragusper.leetcode.topInterviewQuestions.strings

import org.junit.Assert
import org.junit.Test

/**
Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1


Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

 */
class FirstUniqueCharacterinaString {

    @Test
    fun testChallenge1() {
        Assert.assertEquals(0, firstUniqChar("leetcode"))
    }

    @Test
    fun testChallenge2() {
        Assert.assertEquals(2, firstUniqChar("loveleetcode"))
    }

    @Test
    fun testChallenge3() {
        Assert.assertEquals(-1, firstUniqChar("aabb"))
    }

    fun firstUniqChar(s: String): Int {
        val characters = mutableListOf<String>()
        var repeated: Boolean
        for (i in s.indices) {
            characters.add(s[i].toString())
            repeated = false
            for (j in i + 1 until s.length) {
                if (characters.contains(s[j].toString())) {
                    repeated = true
                }
            }
            if (repeated.not()) {
                return i
            }
        }

        return -1
    }
}