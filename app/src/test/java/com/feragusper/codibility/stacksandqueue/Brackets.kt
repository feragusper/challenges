package com.feragusper.codibility.stacksandqueue

import org.junit.Test
import java.util.Stack
import kotlin.math.absoluteValue

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * fun solution(S: String): Int
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
 */
class Brackets {

    @Test
    fun test() {
        assert(1 == solution("{[()()]}"))
        assert(0 == solution("([)()]"))
    }

    private fun solution(S: String): Int {
        val stack = Stack<Char>() // Stack to keep track of opening brackets

        for (char in S) {
            when (char) {
                '(', '{', '[' -> stack.push(char) // Push opening brackets onto the stack
                ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return 0 // Check matching '('
                }
                '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return 0 // Check matching '{'
                }
                ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return 0 // Check matching '['
                }
            }
        }

        return if (stack.isEmpty()) 1 else 0 // Return 1 if all brackets are matched, otherwise 0
    }

}