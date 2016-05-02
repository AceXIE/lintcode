import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/2.
 */
public class UniqueBinarySearchTreesII {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        ans.add(null);
        if (n <= 0) return ans;
        return help(1, n);
    }
    public static List<TreeNode> help(int left, int right) {
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        if (left > right || left <= 0 || right <= 0) treeNodeList.add(null);
        else if (left == right) {
            TreeNode treeNode = new TreeNode(left);
            treeNodeList.add(treeNode);
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> lefttree = help(left, i - 1);
                List<TreeNode> righttree = help(i + 1, right);
                for (int j = 0; j < lefttree.size(); j++) {
                    for (int k = 0; k < righttree.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = lefttree.get(j);
                        root.right = righttree.get(k);
                        treeNodeList.add(root);
                    }
                }
            }
        }
        return treeNodeList;
    }
}
