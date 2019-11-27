/*
 * @lc app=leetcode id=572 lang=java
 * [3,4,5,1,2,null,null,0]\n[4,1,2]
 * [3,4,5,1,null,2]\n[3,1,2]
 * [572] Subtree of Another Tree
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
            boolean flag = false;
            while(s!=null) {
                if (t == null) return false;
                if (s.val == t.val && check(s,t)){
                    flag = true;
                    break;
                }
                else return isSubtree(s.left,t) || isSubtree(s.right,t);
            }
            return flag;
    }
    
    public boolean check(TreeNode s, TreeNode t){
        if(s==null && t == null) return true;
        else if(s==null || t == null) return false;
        //System.out.printf("(%d,%d) ",s.val, t.val);

        if(s.val == t.val)
            return check(s.left,t.left) && check(s.right,t.right);
        else return false;   //must return false
    }
}
// @lc code=end

