/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans =new ArrayList<>();
        //Pre-Order
        PreOrder(root,ans,0);
        Collections.reverse(ans);
        return ans;
    }
    public void PreOrder(TreeNode root,List<List<Integer>> ans, int level){
        if(root==null) return;
        //System.out.print(root.val + "in "+level +" ");
        if(ans.size() == level){
            List<Integer> currLevel = new ArrayList<>();
            currLevel.add(root.val);
            ans.add(currLevel);
        }
        else{
            ans.get(level).add(root.val);
        }
        PreOrder(root.left,ans,level+1);
        PreOrder(root.right,ans,level+1);
    }
}
// @lc code=end

