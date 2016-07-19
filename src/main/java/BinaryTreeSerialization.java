import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/7/19.
 */
public class BinaryTreeSerialization {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.print(serialize(root));
    }
    public static String serialize(TreeNode root) {
        String res = "";
        if (root == null) {
            return res + "#,";
        }
        res += root.val;
        res +=",";

        res += serialize(root.left);
        res += serialize(root.right);

        return res;
    }
    //bfs
    public static String serializeUsingBFS(TreeNode root) {
        if (root == null) return null;
        StringBuffer stringBuffer = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        stringBuffer.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
            stringBuffer.append(",");
            if (tmp.left != null) {
                stringBuffer.append(tmp.left.val);
            } else {
                stringBuffer.append("#");
            }
            stringBuffer.append(",");
            if (tmp.right != null) {
                stringBuffer.append(tmp.right.val);
            } else {
                stringBuffer.append("#");
            }
        }
        return stringBuffer.toString();
    }
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        ArrayList<String> arrayList = new ArrayList<String>(strings.length);
        for (String s : strings) {
            arrayList.add(s);
        }

        TreeNode root = deserializeHelper(arrayList);

        return root;
    }
    public static TreeNode deserializeHelper(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        String val = arrayList.get(0);
        arrayList.remove(0);
        if (val.equals("#")) return  null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(arrayList);
        root.right = deserializeHelper(arrayList);
        return root;
    }
}
