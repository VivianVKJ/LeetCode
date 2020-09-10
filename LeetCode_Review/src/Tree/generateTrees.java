package Tree;

import Tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

//95. Unique Binary Search Trees II
public class generateTrees {
    public static void main(String[] args) {
        System.out.println(generateTrees(3).size());
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generate(1, n);
    }

    public static LinkedList<TreeNode> generate(int min, int max) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (min > max) {
            res.add(null);
            return res;
        }
        //loop to regard every node as a root
        for (int i = min; i <= max; i++) {
            LinkedList<TreeNode> left = generate(min, i - 1);
            LinkedList<TreeNode> right = generate(i + 1, max);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
