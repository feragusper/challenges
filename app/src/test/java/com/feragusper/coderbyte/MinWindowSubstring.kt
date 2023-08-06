package com.feragusper.coderbyte

import org.junit.Test

/**
 * Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr, which will contain only two strings,
 * the first parameter being the string N and the second parameter being a string K of some characters,
 * and your goal is to determine the smallest substring of N that contains all the characters in K.
 * For example: if strArr is ["aaabaaddae", "aed"] then the smallest substring of N that contains the characters a, e,
 * and d is "dae" located at the end of the string. So for this example your program should return the string dae.
 *
 * Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N that contains all of the characters in K
 * is "aabd" which is located at the beginning of the string. Both parameters will be strings ranging in length from 1 to 50 characters
 * and all of K's characters will exist somewhere in the string N. Both strings will only contains lowercase alphabetic characters.
 */
class MinWindowSubstring {

    @Test
    fun testChallenge() {
        assert(minWindowSubstring(arrayOf("ahffaksfajeeubsne", "jefaa")) == "aksfaje")

        assert(minWindowSubstring(arrayOf("aaffhkksemckelloe", "fhea")) == "affhkkse")
    }

    private fun minWindowSubstring(strArr: Array<String>): String {

        val N = strArr[0]
        val K = strArr[1]

        // Create a map to keep track of characters in K and their occurrences
        val charCountMap = mutableMapOf<Char, Int>()
        for (char in K) {
            charCountMap[char] = charCountMap.getOrDefault(char, 0) + 1
        }

        // Variables to keep track of the sliding window
        var left = 0
        var right = 0
        var minWindowSize = Int.MAX_VALUE
        var minWindowStart = 0
        var count = charCountMap.size

        while (right < N.length) {
            val charRight = N[right]

            // Decrease the count of charRight in the map
            if (charCountMap.containsKey(charRight)) {
                charCountMap[charRight] = charCountMap[charRight]!! - 1
                if (charCountMap[charRight] == 0) {
                    count--
                }
            }

            // Move the right pointer to expand the window until all characters in K are included
            right++

            while (count == 0) {
                // Check if the current window is smaller than the previously found minimum window
                if (right - left < minWindowSize) {
                    minWindowSize = right - left
                    minWindowStart = left
                }

                // Shrink the window from the left side
                val charLeft = N[left]
                if (charCountMap.containsKey(charLeft)) {
                    charCountMap[charLeft] = charCountMap[charLeft]!! + 1
                    if (charCountMap[charLeft]!! > 0) {
                        count++
                    }
                }
                left++
            }
        }

        // If no valid window is found, return an empty string
        if (minWindowSize == Int.MAX_VALUE) {
            return ""
        }

        // Return the smallest substring that contains all characters in K
        return N.substring(minWindowStart, minWindowStart + minWindowSize)

    }

}