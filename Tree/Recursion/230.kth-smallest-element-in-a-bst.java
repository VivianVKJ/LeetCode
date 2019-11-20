/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sort = new ArrayList<Integer>();
        Inorder(root,sort,k);
        return sort.get(k-1);
    }
    public void Inorder(TreeNode root,List<Integer> sort,int k){
        if(root!=null && sort.size()<=k){
            Inorder(root.left,sort,k);
            sort.add(root.val);
            Inorder(root.right,sort,k);
        }
        else return;
    }
}

// @lc code=end

