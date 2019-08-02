/*
 * @lc app=leetcode id=99 lang=java
 * In-Order Traversal: left root right
 * [99] Recover Binary Search Tree
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
    TreeNode first=null,second=null,previous=null;
    public void recoverTree(TreeNode root) {
        previous =  new TreeNode(Integer.MIN_VALUE); //ERROR 1
        inOrder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    public void inOrder(TreeNode current){
        if(current!=null){  //ERROR 2
            inOrder(current.left);
            if(current.val<previous.val) {
                if(first==null)
                    first=previous;
                second=current;
                System.out.print(current.val);
            }
            previous = current;
            inOrder(current.right);
        }
        else return;
    }
}

