/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        return Helper(p,q);
    }
    public boolean Helper(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && Helper(p.left,q.left) && Helper(p.right,q.right);
    }
}

