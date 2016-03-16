

import javax.swing.tree.TreeNode;

/**
 * Created by Administrator on 2016/3/15.
 */
public class insertnodeinabinarysearchtree {
    static TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) return node;
        if (node == null) return root;
//        inserNoderecursion(root, node);
        root = inserNodenoRecursion(root, node);
        return root;
    }

    /**
     * 递归实现
     * @param root
     * @param node
     */
    public static void inserNoderecursion(TreeNode root, TreeNode node) {
        if (root.val <= node.val && root.right == null) root.right = node;
        else if (root.val > node.val && root.left == null) root.left = node;
        else if (root.val <= node.val) inserNoderecursion(root.right, node);
        else inserNoderecursion(root.left, node);
    }

    public static TreeNode inserNodenoRecursion(TreeNode root, TreeNode node) {
        TreeNode rootcp = root;
        while (root != null) {
            if (root.val <= node.val && root.right == null) {
                root.right = node;
                break;
            } else if (root.val > node.val && root.left == null) {
                root.left = node;
                break;
            } else if (root.val <= node.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return rootcp;
    }
}
