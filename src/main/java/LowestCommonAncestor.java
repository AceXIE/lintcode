/**
 * Created by Administrator on 2016/4/5.
 * 二叉树
 */
public class LowestCommonAncestor {
    /***
     * 二叉搜索树，直接比较数值
     * @param root
     * @param A
     * @param B
     * @return
     */
    public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || A == null || B ==null) return null;
        if (Math.max(A.val, B.val) < root.val) {
            return lowestCommonAncestorBST(root.left, A, B);
        } else if (Math.min(A.val, B.val) > root.val){
            return lowestCommonAncestorBST(root.right, A, B);
        } else {
            return root;
        }
    }

    /***
     * 二叉树需要递归判断是否在子树上
     * @param root
     * @param A
     * @param B
     * @return
     */
    public static TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || A == null || B == null) return null;
        if (isContern(root.right, A) && isContern(root.right, B)) {
            return lowestCommonAncestorBT(root.right, A, B);
        } else if (isContern(root.left, A) && isContern(root.left, B)) {
            return lowestCommonAncestorBT(root.left, A, B);
        } else {
            return root;
        }
    }
    public static boolean isContern(TreeNode root, TreeNode treeNode) {
        if (root == null) return false;
        if (root == treeNode) return true;
        return (isContern(root.left, treeNode) || isContern(root.right, treeNode));
    }
}
