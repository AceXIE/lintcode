import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2016/3/17.
 */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        if(root == null) return new ArrayList<ArrayList<Integer>>(0);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int f = 0, r = 0;
        while (!queue.isEmpty()) {
            arrayList = new ArrayList<Integer>();
            r = queue.size();
            while (f < r) {
                TreeNode top = queue.poll();
                arrayList.add(top.val);
                if(top.left != null) queue.add(top.left);
                if(top.right != null) queue.add(top.right);
                f++;
            }
            f = 0;
            stack.push(arrayList);
        }

        while (!stack.isEmpty()) {
            ArrayList<Integer> arrayList1 = stack.pop();
            res.add(arrayList1);
        }
        return res;
    }

}
