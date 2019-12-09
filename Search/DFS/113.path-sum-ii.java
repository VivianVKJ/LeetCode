/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> curr = new ArrayList<>();
        if(root==null) return ans;
        curr.add(root.val);
        findPath(root,sum,0,curr);
        return ans;
    }
    public void findPath(TreeNode root, int sum, int currSum, List<Integer> curr){
        //if(root==null) return;
        currSum +=root.val;
    
        if(root.left==null && root.right==null && currSum ==sum){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        if(root.left!=null){
            curr.add(root.left.val);
            findPath(root.left,sum,currSum,curr);
            curr.remove(curr.size()-1);
        }

        if(root.right!=null){
            curr.add(root.right.val);
            findPath(root.right,sum,currSum,curr);
            curr.remove(curr.size()-1);
        }
        
    }
}
// @lc code=end

