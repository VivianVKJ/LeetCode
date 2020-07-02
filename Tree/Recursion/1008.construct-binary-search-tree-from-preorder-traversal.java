/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(0, preorder.length - 1, preorder);
    }

    public TreeNode buildTree(int s, int e, int[] preorder) {
        if (s > e)
            return null;
        TreeNode root = new TreeNode(preorder[s]);
        int rs = s + 1;
        while (rs <= e && preorder[rs] < preorder[s])
            rs++; // right start
        root.left = buildTree(s + 1, rs - 1, preorder);
        root.right = buildTree(rs, e, preorder);
        return root;
    }
}
// @lc code=end
