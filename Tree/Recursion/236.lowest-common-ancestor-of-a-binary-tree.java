/*
 * @lc app=leetcode id=236 lang=java
 * Divide and Qunquer
 * 1.(root,left,right) p/q in different sides ->root
 * 2. else return left or right
 * [236] Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Condition:
        if(root==null) return null;
        if(root==p||root==q) return root;
        
        //Divide:
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        //Conquer:
        if(left!=null && right!=null)  return root;
        return (left!=null) ? left : right;
    }
}

