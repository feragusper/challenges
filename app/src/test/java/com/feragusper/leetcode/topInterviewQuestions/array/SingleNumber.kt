package com.feragusper.leetcode.topInterviewQuestions.array

import org.junit.Assert
import org.junit.Test

/**
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1


Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */
class SingleNumber {

    @Test
    fun testChallenge1() {
        Assert.assertEquals(singleNumber(intArrayOf(2, 2, 1)), 1)
    }

    @Test
    fun testChallenge2() {
        Assert.assertEquals(singleNumber(intArrayOf(4, 1, 2, 1, 2)), 4)
    }

    @Test
    fun testChallenge3() {
        Assert.assertEquals(singleNumber(intArrayOf(1)), 1)
    }

    fun singleNumber(nums: IntArray): Int {
        val mirroredNums = mutableListOf<Int>()

        nums.forEach { num ->
            if (mirroredNums.contains(num)) {
                mirroredNums.remove(num)
            } else {
                mirroredNums.add(num)
            }
        }

        return mirroredNums[0]
    }
}