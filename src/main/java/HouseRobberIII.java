/**
 * Created by Administrator on 2016/7/29.
 */
public class HouseRobberIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.print(houseRobber3(root));
    }
    public static int houseRobber3(TreeNode root) {
        if (root == null) return 0;
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    public static int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
