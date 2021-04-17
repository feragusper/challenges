package com.feragusper.leetcode.daily

import org.junit.Assert
import org.junit.Test

/**
 * IT WORKS!
 */
class AdvantageShuffleUnitTest {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        Assert.assertArrayEquals(
            intArrayOf(24, 32, 8, 12),
            advantageCount(intArrayOf(12, 24, 8, 32), intArrayOf(13, 25, 32, 11))
        )
    }

    @Test
    fun testChallenge2() {
    }

    @Test
    fun testChallenge3() {
    }


    fun advantageCount(A: IntArray, B: IntArray): IntArray {
        val result = mutableListOf<Int>()
        val aElements = A.sorted().toMutableList()
        B.forEach { bElement ->
            var greaterAElement: Int? = null
            for (i in 0 until aElements.size) {
                if (aElements[i] > bElement) {
                    greaterAElement = aElements[i]
                    break
                }
            }
            val elementToAdd = greaterAElement ?: aElements.first()

            result.add(elementToAdd)
            aElements.remove(elementToAdd)
        }
        return result.toIntArray()
    }
}