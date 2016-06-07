/**
 * Created by Administrator on 2016/6/7.
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t2.left = t3; t2.right = t4;
        t5.right = t6;
        root.left = t2; root.right = t5;
        flatten(root);
    }
    public static void flatten(TreeNode root) {
        if (root == null) return;
        while (root != null) {
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
