/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric_iterator(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.val!=right.val) return false;
            if(left.val==right.val){
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetricHelper(root.left,root.right);
    }
    public boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        return (left.val==right.val) && isSymmetricHelper(left.left,right.right) 
                &&isSymmetricHelper(left.right,right.left);
    }
}

