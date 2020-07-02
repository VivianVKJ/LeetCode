package Tree;

public class bstFromPreorder {
    public static void main(String[] args) {
        int[] pre = {8, 5, 1, 7, 10, 12};
        int[] pre2 = {4, 2};
        bstFromPreorder solution = new bstFromPreorder();
        TreeNode root = solution.bstFromPreorder(pre2);
        System.out.println(root.val);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return buildTree(0, n - 1, preorder);
    }

    public TreeNode buildTree(int s, int e, int[] preorder) {
        if (s > e) return null;
        TreeNode root = new TreeNode(preorder[s]);
        int ns = s + 1;
        while (ns <= e && preorder[ns] < preorder[s]) ns++;
        root.left = buildTree(s + 1, ns - 1, preorder);
        root.right = buildTree(ns, e, preorder);
        return root;
    }
}