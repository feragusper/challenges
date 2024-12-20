package com.feragusper.codibility.sorting

import org.junit.Test

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 *
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 *
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 *
 * For example, given array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 *
 *   A[0] = 10    A[1] = 50    A[2] = 5
 *   A[3] = 1
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
class Triangle {

    @Test
    fun test() {
        assert(1 == solution(intArrayOf(10, 2, 5, 1, 8, 20)))
        assert(0 == solution(intArrayOf(10, 50, 5, 1)))
    }

    fun solution(A: IntArray): Int {
        // If the array has fewer than 3 elements, no triplet can exist
        if (A.size < 3) return 0

        // Sort the array
        A.sort()

        // Check for the triangular condition in consecutive triplets
        for (i in 0 until A.size - 2) {
            // Use Long to avoid integer overflow
            if (A[i].toLong() + A[i + 1] > A[i + 2]) {
                return 1
            }
        }

        // If no triplet satisfies the condition, return 0
        return 0
    }

}