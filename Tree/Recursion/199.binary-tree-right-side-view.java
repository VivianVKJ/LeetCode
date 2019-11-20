/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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

    public List<Integer> rightSideView (TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfs(root,res,0);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> res, int level){
        if(root!=null){
            //in(check) - right - left
            if(res.size()==level)
                res.add(root.val);
            dfs(root.right,res,level+1);
            dfs(root.left,res,level+1);
        }
    }


    public List<Integer> rightSideView_dfshash(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        levelTraversal(root,map,0);
        for(int i=0;i<map.size();i++)
            res.add(map.get(i));
        return res;
    }
    public void levelTraversal (TreeNode root,HashMap map, int level){
        if(root!=null){
            map.put(level,root.val);
            levelTraversal(root.left,map,level+1);
            levelTraversal(root.right,map,level+1);
        }
        else return;
    }

}

