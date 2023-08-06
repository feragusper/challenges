package com.feragusper.coderbyte

import org.junit.Test

/**
 * Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
 * the first element will represent a list of comma-separated numbers sorted in ascending order,
 * the second element will represent a second list of comma-separated numbers (also sorted).
 * Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
 * If there is no intersection, return the string false.
 */
class FindIntersection {

    @Test
    fun testChallenge() {
        assert(findIntersection(arrayOf("1, 3, 4, 7, 13", "1, 2, 4, 13, 15")) == "1,4,13")
    }

    private fun findIntersection(strArr: Array<String>): String {
        val (list1, list2) = strArr.map { it.replace(" ", "").split(",").map(String::toInt) }

        var pointer1 = 0
        var pointer2 = 0
        val result = mutableListOf<Int>()

        while (pointer1 < list1.size && pointer2 < list2.size) {
            when {
                list1[pointer1] == list2[pointer2] -> {
                    result.add(list1[pointer1])
                    pointer1++
                    pointer2++
                }
                list1[pointer1] < list2[pointer2] -> pointer1++
                else -> pointer2++
            }
        }

        if (result.isEmpty()) {
            return "false"
        }

        return result.joinToString(",")
    }

}