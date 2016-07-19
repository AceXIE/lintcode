/**
 * Created by Administrator on 2016/7/18.
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum i = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(1);
        TreeNode p = root;
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        System.out.print(i.maxPathSum(root));
    }
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int lmax = helper(root.left);
        int rmax = helper(root.right);

        int curVal = root.val;

        if (lmax > 0) {
            curVal += lmax;
        }
        if (rmax > 0) {
            curVal += rmax;
        }
        if (curVal > max) {
            max = curVal;
        }
        return Math.max(root.val, Math.max(root.val + lmax, root.val + rmax));
    }
}
