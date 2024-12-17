package com.feragusper.codibility.timecomplexity

import org.junit.Test

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
class PermMissingElem {

    @Test
    fun test() {
        assert(4 == solution(intArrayOf(2, 3, 1, 5)))
        assert(1 == solution(intArrayOf(2)))
        assert(2 == solution(intArrayOf(1)))
        assert(1 == solution(intArrayOf()))
    }

    private fun solution(a: IntArray): Int {
        val n = a.size
        val totalSum = (n + 1L) * (n + 2) / 2 // Sum of numbers from 1 to N+1
        val actualSum = a.sum() // Sum of all elements in the array
        return (totalSum - actualSum).toInt()
    }

}