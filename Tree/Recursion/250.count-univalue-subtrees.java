/*
 * @lc app=leetcode id=250 lang=java
 *
 * [250] Count Univalue Subtrees
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        unival(root);
        return count;
    }

    public boolean unival(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null) {
            count += 1;
            return true;
        }
        boolean left = root.left == null ? true : unival(root.left) && root.val == root.left.val;
        boolean right = root.right == null ? true : unival(root.right) && root.val == root.right.val;
        if (left && right)
            count += 1;
        return left && right;
    }
}
// @lc code=end
