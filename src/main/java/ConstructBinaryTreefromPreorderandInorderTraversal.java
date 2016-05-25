/**
 * Created by Administrator on 2016/5/25.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {2,1,3};
        buildTree(preorder,inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public static TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int rootval = preorder[ps];
        int i = is;
        for (; i <= ie; i++) {
            if (rootval == inorder[i]) {
                break;
            }
        }
        TreeNode node = new TreeNode(rootval);
        node.left = helper(preorder, inorder, ps + 1, ps + i - is, is, i - 1);
        node.right = helper(preorder,inorder, ps + i - is + 1, pe, i + 1, ie);
        return node;
    }
}
