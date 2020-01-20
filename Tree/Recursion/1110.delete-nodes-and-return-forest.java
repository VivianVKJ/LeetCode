/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 */
//[1,2,3,null,null,null,4]\n[2,1]
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
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> delete = new HashSet<>();
        for(int d : to_delete) delete.add(d);
        deleteNodes(root,delete); 
        if(!delete.contains(root.val)) ans.add(root);
        return ans;
    }
    public TreeNode deleteNodes(TreeNode root, HashSet delete){
        if(root==null) return root;
        root.left=deleteNodes(root.left,delete);
        root.right = deleteNodes(root.right,delete);
        if(delete.contains(root.val)){
            //System.out.println("root.val="+root.val);
            if(root.left!=null) ans.add(root.left);
            if(root.right!=null) ans.add(root.right);
            return null;
        }
        return root;
    }
}
// @lc code=end

