package com.feragusper.coderbyte

import org.junit.Test

/**
 * Have the function BracketCombinations(num) read num which will be an integer greater than or equal to zero,
 * and return the number of valid combinations that can be formed with num pairs of parentheses.
 * For example, if the input is 3, then the possible combinations of 3 pairs of parenthesis,
 * namely: ()()(), are ()()(), ()(()), (())(), ((())), and (()()).
 * There are 5 total combinations when the input is 3, so your program should return 5.
 */
class BracketCombinations {

    @Test
    fun testChallenge() {
        assert(bracketCombinations(3) == 5)

        assert(bracketCombinations(2) == 2)
    }

    private fun bracketCombinations(num: Int): Int {
        fun countValidCombinations(openCount: Int, closeCount: Int): Int {
            // Base case: If both openCount and closeCount are 0, a valid combination is found.
            if (openCount == 0 && closeCount == 0) {
                return 1
            }

            var totalCombinations = 0

            // Recursive cases:
            // Add an open parenthesis if there are still some openCount left
            if (openCount > 0) {
                totalCombinations += countValidCombinations(openCount - 1, closeCount + 1)
            }

            // Add a close parenthesis if there are still some closeCount left
            if (closeCount > 0) {
                totalCombinations += countValidCombinations(openCount, closeCount - 1)
            }

            return totalCombinations
        }

        // Start the recursive function with openCount = num (num pairs of open parentheses)
        // and closeCount = 0 (no close parentheses added yet).
        return countValidCombinations(num, 0)
    }

}