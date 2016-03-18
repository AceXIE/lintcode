

/**
 * Created by Administrator on 2016/3/17.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        height(root);
        if(root == null) return true;
        int l = 0, r = 0;
        if (root.left != null) l = root.left.val;
        if (root.right != null) r = root.right.val;
        if (Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }
    public int height (TreeNode root) {
        if (root == null) return 0;
        root.val = Math.max(height(root.right),height(root.left)) + 1;
        return root.val;
    }
}
