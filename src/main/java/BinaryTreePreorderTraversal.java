import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2016/3/17.
 */
public class BinaryTreePreorderTraversal {
    /**
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>(0);//返回空数组，不是null
        ArrayList<Integer> res = new ArrayList<Integer>();
        preorder(res, root);
        return res;
    }
    public void preorder(ArrayList<Integer> arrayList, TreeNode root) { //传递对象，即为引用
        if (root != null) {
            arrayList.add(root.val);
            preorder(arrayList, root.left);
            preorder(arrayList, root.right);
        }
    }
    public void preordernorecursion(ArrayList<Integer> arrayList, TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                arrayList.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (! stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }
}
