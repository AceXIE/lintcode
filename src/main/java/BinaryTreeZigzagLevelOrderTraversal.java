import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/5/26.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = root;
        p.left = new TreeNode(9);
        TreeNode ri = new TreeNode(20);
        ri.left = new TreeNode(15);
        ri.right = new TreeNode(7);
        p.right = ri;
        ArrayList<ArrayList<Integer>> ans = zigzagLevelOrder(root);
        for (ArrayList<Integer> a : ans) {
            for (Integer t : a) {
                System.out.print(t);
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if (root == null) return arrayLists;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        boolean left2right = true;
        while (!list.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            if (left2right) {
                TreeNode rightnode = list.getLast();
                TreeNode p = null;
                while (p != rightnode) {
                    p = list.getFirst();
                    arrayList.add(p.val);
                    if (p.left != null) list.addLast(p.left);
                    if (p.right != null) list.addLast(p.right);
                    list.removeFirst();
                    if (list.isEmpty()) break;
                }
            } else {
                TreeNode leftnode = list.getFirst();
                TreeNode p = null;
                while (p != leftnode) {
                    p = list.getLast();
                    arrayList.add(p.val);
                    if (p.right != null) list.addFirst(p.right);
                    if (p.left != null) list.addFirst(p.left);
                    list.removeLast();
                    if (list.isEmpty()) break;
                }
            }
            left2right = !left2right;
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
}
