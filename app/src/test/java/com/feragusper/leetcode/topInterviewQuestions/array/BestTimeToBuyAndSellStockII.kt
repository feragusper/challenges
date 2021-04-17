package com.feragusper.leetcode.topInterviewQuestions.array

import org.junit.Assert
import org.junit.Test

/**

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e., max profit = 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104

 */
class BestTimeToBuyAndSellStockII {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        Assert.assertEquals(7, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    @Test
    fun testChallenge2() {
        Assert.assertEquals(4, maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testChallenge3() {
        Assert.assertEquals(0, maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }

        var profit = 0
        var previousPrice: Int
        var currentPrice: Int
        var goingDown = prices[0] < prices[1]
        var goingUp = prices[0] >= prices[1]
        var holdingStock: Int? = null
        for (i in 1 until prices.size) {
            previousPrice = prices[i - 1]
            currentPrice = prices[i]
            // Going Up
            if (previousPrice < currentPrice) {
                if (goingDown) {
                    // BUY
                    holdingStock = previousPrice
                    println("buying $holdingStock")
                }
                goingDown = false
                goingUp = true
            }
            // Going Down
            if (previousPrice >= currentPrice) {
                if (goingUp) {
                    // SELL
                    holdingStock?.let { holdingStockNotNull ->
                        println("selling $holdingStockNotNull at $previousPrice")
                        profit += previousPrice - holdingStockNotNull
                    }
                }
                goingUp = false
                goingDown = true
            }
        }

        if (goingUp) {
            previousPrice = prices.last()
            // SELL
            holdingStock?.let { holdingStockNotNull ->
                println("selling $holdingStockNotNull at $previousPrice")
                profit += previousPrice - holdingStockNotNull
            }
        }

        return profit
    }
}