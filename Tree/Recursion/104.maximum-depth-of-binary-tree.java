/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int res[] = new int[1];
        res[0]=1;
        dfs(root,1,res);
        return res[0];
    }
    public void dfs(TreeNode root, int level,int[] res){
        if(root==null)  return;
        if(level>res[0]) res[0] = level;
        // System.out.printf("(%d,%d,%d) ",root.val,level,res[0]);


        if(root.left!=null) 
            dfs(root.left,level+1,res);
        if(root.right!=null)
            dfs(root.right,level+1,res);
    }
}

