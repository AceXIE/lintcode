/**
 * Created by Administrator on 2016/7/2.
 * 几个情况：
 * 1. root node is the target node: find the right most node if its left child and replace the root node
 * 2. target node has no child leaf: set its parent left/right child to null
 * 3. target node has only one child: replace target node with that child
 * 4. target node has both children: find the right most leaf of its left children and replace the target node; remember to set its parent child to null and replace children of this node to the target node children (another corner case: check if its child is itself)
 */
public class RemoveNodeinBinarySearchTree {

    public static TreeNode removeNode(TreeNode root, int value) {
        if (root == null) return null;
        if (root.val == value) return swapNode(null, root);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null && cur.left.val == value) {
                swapNode(cur, cur.left);
                break;
            } else if (cur.right != null && cur.right.val == value) {
                swapNode(cur, cur.right);
                break;
            } else if (value < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return root;
    }
    public static TreeNode swapNode(TreeNode parent, TreeNode target) {
        TreeNode newNode = null;
        if (target.left == null && target.right == null) {
            newNode = null;
        } else if (target.left == null) {
            newNode = target.right;
        } else if (target.right == null) {
            newNode = target.left;
        } else {
            newNode = findRightMost(target.left);
            if (target.left != newNode) {
                newNode.left = target.left;
            }
            newNode.right = target.right;
        }

        if (parent != null && parent.left == target) {
            parent.left = newNode;
        } else if (parent != null && parent.right == target) {
            parent.right = newNode;
        }
        return newNode;
    }
    static TreeNode findRightMost(TreeNode child) {
        TreeNode parent = null;
        while (child.right != null) {
            parent = child;
            child = child.right;
        }
        if (parent != null && child == parent.left) {
            parent.left = null;
        } else if (parent != null && child == parent.right) {
            parent.right = null;
        }
        return child;
    }
}
