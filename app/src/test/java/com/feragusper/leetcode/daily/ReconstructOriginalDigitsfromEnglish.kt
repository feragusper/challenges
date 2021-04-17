package com.feragusper.leetcode.daily

import org.junit.Assert
import org.junit.Test

/**
 * IT WORKS!
 */
class ReconstructOriginalDigitsfromEnglish {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        Assert.assertEquals("012", originalDigits("owoztneoer"))
    }

    @Test
    fun testChallenge2() {
        Assert.assertEquals("8", originalDigits("egith"))
    }

    @Test
    fun testChallenge3() {
        Assert.assertEquals("9", originalDigits("nnei"))
    }

    @Test
    fun testChallenge4() {
        Assert.assertEquals("00", originalDigits("zerozero"))
    }

    fun originalDigits(s: String): String {
        var result = ""

        val listOfDigits = mutableListOf<Int>()
        var wordCountAndS = processDigit("zero", "z", s)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(0)
        }
        wordCountAndS = processDigit("two", "w", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(2)
        }
        wordCountAndS = processDigit("four", "u", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(4)
        }
        wordCountAndS = processDigit("six", "x", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(6)
        }
        wordCountAndS = processDigit("eight", "g", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(8)
        }
        wordCountAndS = processDigit("five", "f", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(5)
        }
        wordCountAndS = processDigit("seven", "v", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(7)
        }
        wordCountAndS = processDigit("three", "h", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(3)
        }
        wordCountAndS = processDigit("one", "o", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(1)
        }
        wordCountAndS = processDigit("nine", "i", wordCountAndS.second)
        for (i in 1..wordCountAndS.first) {
            listOfDigits.add(9)
        }

        listOfDigits.sorted().forEach {
            result += it.toString()
        }
        return result
    }

    private fun processDigit(word: String, char: String, s: String): Pair<Int, String> {
        val wordCount = s.count {
            it.toString() == char
        }

        var newS = s
        var matchCount: Int
        if (wordCount > 0) {
            for (i in word.indices) {
                matchCount = 0
                loop@ for (j in newS.indices) {
                    if (matchCount == wordCount) {
                        break@loop
                    }
                    if (newS.length > j && newS[j] == word[i]) {
                        matchCount++
                        newS = newS.removeRange(IntRange(j, j))
                    }
                }
            }
        }

        if (newS.length < 3) {
            newS = ""
        }

        return Pair(wordCount, newS)
    }
}