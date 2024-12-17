package com.feragusper.codibility.countingelements

import org.junit.Test

/**
 * Write a function:
 *
 * fun solution(A: IntArray): Int
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
class MissingInteger {

    @Test
    fun test() {
        assert(5 == solution(intArrayOf(1, 3, 6, 4, 1, 2)))
        assert(4 == solution(intArrayOf(1, 2, 3)))
        assert(1 == solution(intArrayOf(-1, -3)))
    }

    private fun solution(a: IntArray): Int {
        val normalizedArray = a.filter { it > 0 }.sorted().distinct()
        normalizedArray.forEachIndexed { index, i ->
            val normalizedIndex = index + 1
            if (i != normalizedIndex) {
                return normalizedIndex
            }
        }

        return normalizedArray.size + 1
    }

}