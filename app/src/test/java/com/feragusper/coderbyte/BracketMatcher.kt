package com.feragusper.coderbyte

import org.junit.Test

/**
 * Have the function BracketMatcher(str) take the str parameter being passed and return 1
 * if the brackets are correctly matched and each one is accounted for.
 * Otherwise return 0. For example: if str is "(hello (world))", then the output should be 1,
 * but if str is "((hello (world))" the the output should be 0 because the brackets do not correctly match up.
 * Only "(" and ")" will be used as brackets. If str contains no brackets return 1.
 */
class BracketMatcher {

    @Test
    fun testChallenge() {
        assert(bracketMatcher("(coder)(byte))") == 0)

        assert(bracketMatcher("(c(oder)) b(yte)") == 1)
    }

    private fun bracketMatcher(strArr: String): Int {
        var openCount = 0

        for (char in strArr) {
            if (char == '(') {
                openCount++
            } else if (char == ')') {
                if (openCount == 0) {
                    return 0
                }
                openCount--
            }
        }

        return if (openCount == 0) 1 else 0
    }

}