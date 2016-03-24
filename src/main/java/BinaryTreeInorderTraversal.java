import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by xk on 2016/3/24.
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
//        inorderRec(root, res);//递归
        TreeNode p = root;
        while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                res.add(t.val);
                p = t.right;
            }
        }
        return res;
    }

    /**
     * 递归的方法实现，传入为对象，引用。
     * @param root
     * @param res
     */
    public static void inorderRec(TreeNode root, ArrayList<Integer> res) {
        if(root != null) {
            inorderRec(root.left,res);
            res.add(root.val);
            inorderRec(root.right,res);
        }
    }
}
