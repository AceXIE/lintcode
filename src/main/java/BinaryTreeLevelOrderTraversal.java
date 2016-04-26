import javax.swing.text.TabExpander;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/4/26.
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode treeNode = new TreeNode(20);
        treeNode.left = new TreeNode(15);
        treeNode.right = new TreeNode(7);
        root.right = treeNode;
        ArrayList<ArrayList<Integer>> res = levelOrder(root);
        for (ArrayList<Integer> t : res) {
            for (Integer integer : t) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    /***
     * 层序遍历
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if (root == null) return arrayLists;
        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p != null) {
                level.add(p.val);
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            } else {
                arrayLists.add(level);
                if (!queue.isEmpty()) {
                    level = new ArrayList<Integer>();//!!!!!
                    queue.offer(null);
                }
            }
        }
        return arrayLists;
    }
    public static ArrayList<ArrayList<Integer>> levelOrderUsingDFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(getDepth(root));
        getLevelOrder(root, res, 0);
        return res;
    }
    public static void getLevelOrder(TreeNode treeNode, ArrayList<ArrayList<Integer>> res, int level) {
        if (treeNode == null) return;
//        res.add(level, ArrayList<Integer>);
        //TODO: 接下来不知道怎么做了，如果是vector的话，可以直接进行res[level].push_back(treeNode.val)
        //不知道ArrayList怎么做了
    }
    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return ((left > right)?(left):(right)) + 1;
    }
}
