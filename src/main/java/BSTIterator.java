import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2016/4/26.
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator (TreeNode root) {
        pushAll(root);
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public TreeNode next() {
        TreeNode treeNode = stack.peek();
        stack.pop();
        pushAll(treeNode.right);
        return treeNode;
    }
    public void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
