/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
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
    Map<TreeNode,TreeNode> map=new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        if(K==0){
            ans.add(target.val);
            return ans;
        }

        //map.put(root,null);
        Traversal(root,null);

        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size--!=0){
                TreeNode curr = queue.poll();
                if(map.containsKey(curr)){
                    if(map.get(curr)!=null){
                        //System.out.printf("<%d>",curr.val);
                        queue.offer(map.get(curr));
                        map.remove(curr);
                    }
                }
                if(curr.left!=null && map.containsKey(curr.left)) {
                   // System.out.printf("<%d>",curr.left.val);
                    queue.offer(curr.left);
                    map.remove(curr.left);
                }
                if(curr.right!=null && map.containsKey(curr.right)) {
                   // System.out.printf("<%d>",curr.right.val);
                    queue.offer(curr.right);
                    map.remove(curr.right);
                }
            }
            K--;
            if(K==0) break;   
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }

    public void Traversal(TreeNode node, TreeNode par) {
        if (node != null) {
            map.put(node, par);
            Traversal(node.left, node);
            Traversal(node.right, node);
        }
    }
}
// @lc code=end

