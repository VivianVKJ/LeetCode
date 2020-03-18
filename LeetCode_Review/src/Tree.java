import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static void main(String[] args) throws IOException {
        TreeNode s = stringToTreeNode("[3,4,5,1,null,2]");
        TreeNode t = stringToTreeNode("[3,1,2]");
        boolean ret = new Solution().isSubtree(s, t);
        String out = booleanToString(ret);
        System.out.print(out);

    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }


    static class Solution {
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
            System.out.printf("(%d,%d) ",s.val, t.val);
            if(s.val == t.val)
                return check(s.left,t.left) && check(s.right,t.right);
            else return false;
        }
    }
}
