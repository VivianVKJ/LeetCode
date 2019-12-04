/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal_DFS(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        postTraversal(root, out);
        return out;
    }
    public void postTraversal(TreeNode root, List<Integer> out){
        if(root!=null){
            postTraversal(root.left, out);
            postTraversal(root.right, out);
            out.add(root.val);
        }
        else return;
    }
}

