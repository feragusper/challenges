package com.feragusper.leetcode.daily

import org.junit.Test

/**
 * IT WORKS!
 */
class FlipBinaryTreeToMatchPreorderTraversal {

    @Test
    fun challengeDraft() {

    }

    @Test
    fun testChallenge1() {
    }

    @Test
    fun testChallenge2() {
    }

    @Test
    fun testChallenge3() {
    }

    @Test
    fun testChallenge4() {
    }

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    fun flipMatchVoyage(root: TreeNode?, voyage: IntArray): List<Int> {
        return tryToFlipOrDie(root, voyage, 0, mutableListOf())
    }

    private fun tryToFlipOrDie(
        node: TreeNode?,
        voyage: IntArray,
        voyageIndex: Int,
        result: MutableList<Int>
    ): List<Int> {
        node?.let { nodeNotNull ->
            if (nodeNotNull.`val` != voyage[voyageIndex]) {
                result.add(-1)
                return result
            }

            val nodeLeft = nodeNotNull.left
            if (nodeLeft != null && nodeLeft.`val` != voyage[voyageIndex]) {
                val nodeRight = nodeNotNull.right
                if (nodeRight != null && nodeRight.`val` != voyage[voyageIndex]) {
                    result.add(-1)
                    return result
                } else {
                    node.left = nodeRight
                    node.right = nodeLeft
                    result.add(nodeRight!!.`val`)
                }
            }
            tryToFlipOrDie(
                node = nodeNotNull.left ?: nodeNotNull.right,
                voyage = voyage,
                voyageIndex = voyageIndex + 1,
                result = result
            )
        }

        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}