package com.feragusper.codibility.countingelements

import org.junit.Test

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing.
 *
 * The goal is to check whether array A is a permutation.
 *
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * the function should return 1.
 *
 * Given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
class PermCheck {

    @Test
    fun test() {
        assert(solution(intArrayOf(4, 1, 3, 2)) == 1)
        assert(solution(intArrayOf(4, 1, 3)) == 0)
    }

    private fun solution(a: IntArray): Int {
        val n = a.size
        val count = BooleanArray(n)
        for (i in a.indices) {
            if (a[i] > n) {
                return 0
            }
            if (count[a[i] - 1]) {
                return 0
            }
            count[a[i] - 1] = true
        }
        return 1
    }

}