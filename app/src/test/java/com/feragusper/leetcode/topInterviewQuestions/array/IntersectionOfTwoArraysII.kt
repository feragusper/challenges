package com.feragusper.leetcode.topInterviewQuestions.array

import org.junit.Assert
import org.junit.Test

/**
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
class IntersectionOfTwoArraysII {

    @Test
    fun testChallenge1() {
        Assert.assertArrayEquals(
            intArrayOf(2, 2),
            intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
        )
    }

    @Test
    fun testChallenge2() {
        Assert.assertArrayEquals(
            intArrayOf(4, 9),
            intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
        )
    }

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val intersection = mutableListOf<Int>()
        val nums2Mutable = nums2.toMutableList()

        nums1.forEach { num1 ->
            if (nums2Mutable.contains(num1)) {
                nums2Mutable.remove(num1)
                intersection.add(num1)
            }
        }

        return intersection.toIntArray()
    }
}