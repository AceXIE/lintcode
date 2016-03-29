import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xk on 2016/3/29.
 */
public class SearchRangeinBinarySearchTree {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        inorder(root, res, k1, k2);
        return res;
    }
    public static void inorder(TreeNode root, ArrayList<Integer> res, int k1, int k2) {
        if (root != null) {
            inorder(root.left, res, k1, k2);
            if ( root.val<= k2 && root.val >= k1) {
                res.add(root.val);
            }
            inorder(root.right, res, k1, k2);
        }
    }
}
