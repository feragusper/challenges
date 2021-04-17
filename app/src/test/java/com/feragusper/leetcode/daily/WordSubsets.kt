package com.feragusper.leetcode.daily

import org.junit.Assert
import org.junit.Test

/**
 * IT WORKS!
 */
class WordSubsets {
    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
        Assert.assertArrayEquals(
            arrayOf("facebook", "google"),
            wordSubsets(
                arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
                arrayOf("e", "oo")
            ).toTypedArray()
        )
    }

    @Test
    fun testChallenge2() {

    }

    @Test
    fun testChallenge3() {
    }


    fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {
        val result = mutableListOf<String>()

        A.forEach { aWord ->
            var wordMatch = 0
            for (i in B.indices) {
                var charMatch = 0
                var aWordCopy = aWord
                val bWord = B[i]
                if (bWord.length > aWord.length) {
                    continue
                }
                for (j in bWord.indices) {
                    if (aWordCopy.contains(bWord[j]).not()) {
                        break
                    }
                    aWordCopy = aWordCopy.removeRange(aWordCopy.indexOf(bWord[j]), aWordCopy.indexOf(bWord[j]) + 1)
                    charMatch++
                }
                if (charMatch == bWord.length) {
                    wordMatch++
                }
            }
            if (wordMatch == B.size) {
                result.add(aWord)
            }
        }

        return result
    }
}