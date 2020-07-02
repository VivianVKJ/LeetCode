package BinarySearch;

import Tree.TreeNode;

public class completeTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        public static int countNodes (TreeNode root){
            int depth = treeDepth(root);
            if (depth <= 1)
                return depth;
            int max = (int) Math.pow(2, depth - 1);
            System.out.println("max = " + max);
            int l = 0, r = max - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (exist(root, mid, depth - 1))
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            return r + max;
        }

        public static int treeDepth (TreeNode root){
            if (root == null)
                return 0;
            return 1 + treeDepth(root.left);
        }

        public static boolean exist (TreeNode root,int idx, int depth){
            int max = (int) Math.pow(2, depth);
            while (depth > 0) {
                if (idx < max / 2) {
                    root = root.left;
                } else {
                    root = root.right;
                    idx -= max / 2;
                }
                depth--;
                max /= 2;
            }
            return root != null;
        }
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));
    }


}
