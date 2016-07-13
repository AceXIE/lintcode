

/**
 * Created by Administrator on 2016/7/13.
 */
public class Subtree {
    public static void main(String[] args) {

    }
    public static boolean isSubTree(TreeNode T1, TreeNode T2) {
        if (T2 == null) return true;
        if (T1 == null) return false;
        boolean result = false;
        if (T1.val == T2.val) {
            result = helper(T1, T2);
        }
        if (!result) {
            result = isSubTree(T1.left, T2);
        }
        if (!result) {
            result = isSubTree(T1.right, T2);
        }

        return result;
    }
    public static boolean helper(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) return true;
        if (T1 != null && T2 != null && T1.val == T2.val)
            return helper(T1.left, T2.left) && helper(T1.right, T2.right);
        return false;
    }
}
