package com.feragusper.codibility.countingelements

import org.junit.Test

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 *
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int N, int[] A); }
 *
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
class MaxCounters {

    @Test
    fun test() {
        assert(intArrayOf(3, 2, 2, 4, 2).contentEquals(solution(5, intArrayOf(3, 4, 4, 6, 1, 4, 4))))
    }

    private fun solution(n: Int, a: IntArray): IntArray {
        val counters = IntArray(n) { 0 }
        var currentMax = 0 // Tracks the maximum value of any counter
        var lastUpdate = 0 // Tracks the last max counter update

        for (operation in a) {
            if (operation in 1..n) {
                val index = operation - 1
                // Apply lazy update for the counter
                counters[index] = maxOf(counters[index], lastUpdate)
                counters[index]++
                currentMax = maxOf(currentMax, counters[index])
            } else if (operation == n + 1) {
                // Set lastUpdate to the current max
                lastUpdate = currentMax
            }
        }

        // Final lazy update for all counters
        for (i in counters.indices) {
            counters[i] = maxOf(counters[i], lastUpdate)
        }

        return counters
    }

}