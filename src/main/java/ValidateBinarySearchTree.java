/**
 * Created by Administrator on 2016/8/24.
 */
public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return  true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
