import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public static int countNodes(TreeNode root) {
        int depth = treeDepth(root);
        if (depth <= 1)
            return depth;
        int max = (int) Math.pow(2, depth - 1);
        int l = 0, r = max - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (exist(root, mid, depth - 1))
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r + max;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + treeDepth(root.left);
    }

    public static boolean exist(TreeNode root, int idx, int depth) {
        int max = (int) Math.pow(2, depth);
        while (depth > 0) {
            if (idx < max / 2) {
                root = root.left;
            } else {
                root = root.right;
                idx -= max / 2;
            }
            depth--;
            max /= 2;
        }
        return root != null;
    }

    public static int countNodes_ON(TreeNode root) {
        return root == null ? 0 : (1 + countNodes(root.left) + countNodes(root.right));
    }
}
// @lc code=end
