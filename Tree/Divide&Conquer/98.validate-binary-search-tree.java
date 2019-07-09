/*
 * @lc app=leetcode id=98 lang=java
 * Divide and Conquer
 * [98] Validate Binary Search Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        checkValid(root, null, null);
    }
    public boolean checkValid(TreeNode root, TreeNode min, TreeNode max){
        if(root==null) return true;
        if(min!=null && root.val<=min.val || max!=null && root.val>=max.val) return false;
        return checkValid(root.left, min, root) && checkValid(root.right, root, max);
    }
}

