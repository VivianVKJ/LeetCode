/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
 */

// @lc code=start
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
    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root==null) 
            return new TreeNode(val);
        if(val<root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right,val);
        return root;
    }
    public TreeNode insertIntoBST_Traverse(TreeNode root, int val) {
        TreeNode x = root, y = null;
        while(x!=null){
            y=x;
            if(val<x.val) x = x.left;
            else x = x.right;
        }
        TreeNode insert = new TreeNode(val);
        if(y==null)
            root = new TreeNode(val);
        else {
            if(val<y.val) y.left = insert;
            else y.right = insert;
        }
        return root;
    }
}
// @lc code=end

