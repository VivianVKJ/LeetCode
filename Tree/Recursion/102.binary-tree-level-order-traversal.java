/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        DFS(root,ans,0);
        return ans;
    }
    public void DFS(TreeNode root, List<List<Integer>> ans, int level){
        if(root==null) return;
        if(ans.size()==level){
            List<Integer> curr = new ArrayList<>();
            curr.add(root.val);
            ans.add(curr);
        }else{
            ans.get(level).add(root.val);
        }
        DFS(root.left, ans, level+1);
        DFS(root.right, ans, level+1);
    }
}
// @lc code=end

