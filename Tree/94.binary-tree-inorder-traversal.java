/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        preTraversal(root, out);
        return out;
    }
    public void preTraversal(TreeNode root, List<Integer> out){
        if(root!=null){
            preTraversal(root.left, out);
            out.add(root.val);
            preTraversal(root.right, out);
        }
        else return;
    }
}

