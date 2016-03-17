

/**
 * Created by Administrator on 2016/3/17.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        Integer depth = new Integer(0);
        return isB(root, depth);
    }
    public boolean isB(TreeNode root, Integer depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int ld = 0, rd = 0;
        if ( isB(root.left, ld) && isB(root.right, rd) ) {
            if (Math.abs(ld - rd) > 1) {
                return false;
            }
            depth = Math.max(ld, rd) + 1;
            return true;
        }
        return false;
    }
}
