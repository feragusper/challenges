package com.feragusper.codibility.prefixsums

import org.junit.Test

/**
 * Write a function:
 *
 * fun solution(A: Int, B: Int, K: Int): Int
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A-B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */
class CountDiv {

    @Test
    fun test() {
        assert(solution(6, 11, 2) == 3)
    }

    private fun solution(a: Int, b: Int, k: Int): Int {
        val countUpToB = b / k
        val countUpToA = (a - 1) / k
        return countUpToB - countUpToA
    }

}