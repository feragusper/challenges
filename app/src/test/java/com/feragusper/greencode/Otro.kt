package com.feragusper.greencode

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.math.absoluteValue

/**
 * Dado un conjunto de nros enteros L (por ejemplo L=[1,8,-23,3,8,-2]) y un entero d (de distancia, por ejemplo d=5),
 * retornar un entero q (de cantidad) que cuente la cantidad de parejas de nros distintos de L,
 * siendo cuya distancia es d.
 * Por ejemplo, con L y d dados anteriormente como ejemplo, el valor q debe ser igual a 2
 * (porque las parejas son 8 con 3 y -2 con 3)
 */
class Otro {

    @Test
    fun testChallenge1() {
        Assert.assertEquals(2, findCouples(intArrayOf(1, 8, -23, 3, 8, -2), 5))
    }

    fun findCouples(L: IntArray, d: Int): Int {
        var q = 0
        val couplesMatch = arrayListOf<Pair<Int, Int>>()

        for (i in L.indices) {
            for (j in i + 1 until L.size) {
                val left = L[i]
                val right = L[j]
                if (isIn(couplesMatch, left, right).not() && (left - right).absoluteValue == d) {
                    couplesMatch.add(Pair(left, right))
                    q++
                }
            }
        }

        return q
    }

    private fun isIn(couplesMatch: ArrayList<Pair<Int, Int>>, left: Int, right: Int): Boolean {
        for (i in 0 until couplesMatch.size) {
            if ((couplesMatch[i].first == left && couplesMatch[i].second == right) || (couplesMatch[i].first == right && couplesMatch[i].second == left)) {
                return true
            }
        }

        return false
    }

}