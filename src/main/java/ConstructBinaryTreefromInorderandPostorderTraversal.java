import java.util.HashMap;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {1,2,3};
        int[] postorder = {1,3,2};
        TreeNode treeNode = buildTree(inorder, postorder);
        printTree(treeNode);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length == 0 || postorder.length == 0) return null;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i);
        }
        return help(inorder,postorder,0,inorder.length - 1, 0, postorder.length - 1, hashMap);
    }
    public static TreeNode help(int[] inorder, int[] postorder, int inl,int inr,int postl,int postr, HashMap<Integer, Integer> hashMap) {
        if (inl>inr || postl>postr) return null;
        TreeNode root = new TreeNode(postorder[postr]);
        int index = hashMap.get(root.val);
        root.left = help(inorder,postorder,inl,index-1,postl,postl+index-inl-1,hashMap);
        root.right = help(inorder,postorder,index+1,inr,postr-(inr-index),postr-1,hashMap);
        return root;
    }
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val);
            printTree(root.right);
        }
    }
}
