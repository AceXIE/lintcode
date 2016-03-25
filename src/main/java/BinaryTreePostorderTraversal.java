import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2016/3/25.
 */
public class BinaryTreePostorderTraversal {
    /***
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
//        postorderRec(root, res);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == pre) {
                stack.pop();
                res.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * Recursion 递归实现
     * @param root
     * @param arrayList
     */
    public static void postorderRec(TreeNode root, ArrayList<Integer> arrayList) {
        if (root != null) {
            postorderRec(root.left, arrayList);
            postorderRec(root.right, arrayList);
            arrayList.add(root.val);
        }
    }
}
