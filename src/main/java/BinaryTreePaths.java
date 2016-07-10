import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public class BinaryTreePaths {
    private List<String> ans = new LinkedList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new LinkedList<String>();
        String path = String.valueOf(root.val);
        help(root, path);
        return ans;
    }
    public void help(TreeNode root, String path) {
        if (root.left == null && root.right ==null) ans.add(path);
        if (root.left != null) help(root.left, path+"->"+root.left.val);
        if (root.right != null) help(root.right, path+"->"+root.right.val);
    }
}
