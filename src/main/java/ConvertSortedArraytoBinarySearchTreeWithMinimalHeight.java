/**
 * Created by Administrator on 2016/4/28.
 */
public class ConvertSortedArraytoBinarySearchTreeWithMinimalHeight {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7};
        TreeNode root = sortedArrayToBST(A);
    }
    public static TreeNode sortedArrayToBST(int[] A) {
        if (A == null) return null;
        return helper(A, 0, A.length - 1);
    }
    public static TreeNode helper(int[] A, int s, int e) {
        if (s > e) {
            return null;
        } else if (s == e) {
            return new TreeNode(A[s]);
        } else {
            int mid = (s + e)/2;
            TreeNode treeNode = new TreeNode(A[mid]);
            treeNode.left = helper(A, s, mid - 1);
            treeNode.right = helper(A, mid + 1, e);
            return treeNode;
        }
    }
}
