/*
 * @lc app=leetcode id=662 lang=java
 * [1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2]
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        TreeNode head = root;
        List<Integer> lefts = new ArrayList<Integer>();
        int[] ans = new int[1];  //int ans = 0;
        head.val = 0;
        DFSCount(head,0,lefts,ans);
        // System.out.printf("{ans=%d}",ans[0]);

        return ans[0];
    }
    public void DFSCount(TreeNode head,int depth, List<Integer> lefts,int[] ans){  
        if(head==null) return;
        if(depth==lefts.size()) lefts.add(head.val);
        ans[0] = Math.max(ans[0],head.val-lefts.get(depth)+1);

        if(head.left!=null) head.left.val = head.val*2;
        if(head.right!=null) head.right.val = head.val*2+1;

        DFSCount(head.left,depth+1, lefts, ans);
        DFSCount(head.right,depth+1, lefts, ans);
    }
}

