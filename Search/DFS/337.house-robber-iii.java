/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val;
 * TreeNodeleft; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val; // take root
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
// @lc code=end
