package com.feragusper.leetcode.daily

import org.junit.Assert
import org.junit.Test

/**
 * IT WORKS!
 */
class RoadRepair {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        Assert.assertEquals(
            17,
            getMinCost(
                arrayOf(
                    5,
                    5,
                    3,
                    1,
                    4,
                    6
                ),
                arrayOf(
                    5,
                    9,
                    8,
                    3,
                    15,
                    1
                )
            )
        )
    }

    @Test
    fun testChallenge2() {

    }

    @Test
    fun testChallenge3() {
    }


    fun getMinCost(crew_id: Array<Int>, job_id: Array<Int>): Long {
        var result = 0L
        val crewIdSorted = crew_id.sorted()
        val jobIdSorted = job_id.sorted()

        for (i in crewIdSorted.indices) {
            if (jobIdSorted[i] >= crewIdSorted[i]) {
                result += (jobIdSorted[i] - crewIdSorted[i])
            } else if (jobIdSorted[i] < crewIdSorted[i]) {
                result += (crewIdSorted[i] - jobIdSorted[i])
            }
        }

        return result
    }

}