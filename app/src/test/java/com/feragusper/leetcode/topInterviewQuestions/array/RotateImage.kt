package com.feragusper.leetcode.topInterviewQuestions.array

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:


Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
 */
class RotateImage {

    @Test
    fun testChallenge1() {
        Assert.assertEquals(
            true,
            isValidSudoku(
                arrayOf(
                    "53..7....".toCharArray(),
                    "6..195...".toCharArray(),
                    ".98....6.".toCharArray(),
                    "8...6...3".toCharArray(),
                    "4..8.3..1".toCharArray(),
                    "7...2...6".toCharArray(),
                    ".6....28.".toCharArray(),
                    "...419..5".toCharArray(),
                    "....8..79".toCharArray()
                )
            )
        )
    }

    @Test
    fun testChallenge2() {
        Assert.assertEquals(
            false,
            isValidSudoku(
                arrayOf(
                    "83..7....".toCharArray(),
                    "6..195...".toCharArray(),
                    ".98....6.".toCharArray(),
                    "8...6...3".toCharArray(),
                    "4..8.3..1".toCharArray(),
                    "7...2...6".toCharArray(),
                    ".6....28.".toCharArray(),
                    "...419..5".toCharArray(),
                    "....8..79".toCharArray()
                )
            )
        )
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // init data
        // init data
        val rows: Array<HashMap<Int, Int>?> = arrayOfNulls(9)
        val columns: Array<HashMap<Int, Int>?> = arrayOfNulls(9)
        val boxes: Array<HashMap<Int, Int>?> = arrayOfNulls(9)
        for (i in 0..8) {
            rows[i] = HashMap()
            columns[i] = HashMap()
            boxes[i] = HashMap()
        }

        // validate a board

        // validate a board
        for (i in 0..8) {
            for (j in 0..8) {
                val num = board[i][j]
                if (num != '.') {
                    val n = num.toInt()
                    val box_index = i / 3 * 3 + j / 3

                    // keep the current cell value
                    rows[i]!![n] = rows[i]!!.getOrDefault(n, 0) + 1
                    columns[j]!![n] = columns[j]!!.getOrDefault(n, 0) + 1
                    boxes[box_index]!![n] = boxes[box_index]!!.getOrDefault(n, 0) + 1

                    // check if this value has been already seen before
                    if (rows[i]!![n]!! > 1 || columns[j]!![n]!! > 1 || boxes[box_index]!![n]!! > 1) return false
                }
            }
        }

        return true
    }

}