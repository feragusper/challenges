package com.feragusper.leetcode.daily

import org.junit.Test

/**
 * IT WORKS!
 */
class ActiveTraders {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        mostActive(
            arrayOf(
                "Bigcorp",
                "Bigcorp",
                "Acme",
                "Bigcorp",
                "Zork",
                "Zork",
                "Abc",
                "Bigcorp",
                "Acme",
                "Bigcorp",
                "Bigcorp",
                "Zork",
                "Bigcorp",
                "Zork",
                "Zork",
                "Bigcorp",
                "Acme",
                "Bigcorp",
                "Acme",
                "Bigcorp",
                "Acme",
                "Littlecorp",
                "Nadircorp"
            )
        )
    }

    @Test
    fun testChallenge2() {

    }

    @Test
    fun testChallenge3() {
    }

    fun mostActive(customers: Array<String>): Array<String> {
        val result = mutableListOf<String>()
        val customerCount = mutableMapOf<String, Int>()

        customers.forEach { customer ->
            customerCount[customer] = customerCount[customer]?.plus(1) ?: 1
        }

        customerCount.forEach { (customer, count) ->
            if (((count * 100).toDouble() / customers.size.toDouble()) >= 5) {
                result.add(customer)
            }
        }

        return result.sorted().toTypedArray()
    }
}