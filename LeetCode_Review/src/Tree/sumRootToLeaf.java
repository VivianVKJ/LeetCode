package Tree;

import Tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static Tree.utils.TreeNode.buildTree;

public class sumRootToLeaf {
    static List<Integer> leaf = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] data = {1, 0, 1, 0, 1, 0, 1};
        TreeNode[] nodes = new TreeNode[data.length];
        for (int i = 0; i < data.length; i++) {
            nodes[i] = data[i] == null ? null : new TreeNode(data[i].intValue());
        }
        TreeNode root = buildTree(data);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        traversal(root, 0);
        int ans = 0;
        for (int i : leaf) ans += i;
        return ans;
    }

    public static void traversal(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaf.add(sum * 2 + root.val);
        }
        traversal(root.left, sum * 2 + root.val);
        traversal(root.right, sum * 2 + root.val);
    }
}
