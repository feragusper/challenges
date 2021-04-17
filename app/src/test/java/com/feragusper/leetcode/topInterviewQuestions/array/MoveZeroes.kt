package com.feragusper.leetcode.topInterviewQuestions.array

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
 */
class MoveZeroes {

    @Test
    fun testChallenge1() {
        Assert.assertArrayEquals(
            intArrayOf(1, 3, 12, 0, 0),
            moveZeroes(intArrayOf(0, 1, 0, 3, 12))
        )
    }

    @Test
    fun testChallenge2() {
        Assert.assertArrayEquals(
            intArrayOf(0),
            moveZeroes(intArrayOf(0))
        )
    }

    @Test
    fun testChallenge3() {
        Assert.assertArrayEquals(
            intArrayOf(1, 0),
            moveZeroes(intArrayOf(0, 1))
        )
    }

    fun moveZeroes(nums: IntArray): IntArray {
        val nonZeroNums = nums.filter { it != 0 }
        val firstZeroIndex = nums.size - (nums.size - nonZeroNums.size)

        nonZeroNums.forEachIndexed { index, i ->
            nums[index] = i
        }
        for (i in firstZeroIndex until nums.size) {
            nums[i] = 0
        }

        return nums
    }
}