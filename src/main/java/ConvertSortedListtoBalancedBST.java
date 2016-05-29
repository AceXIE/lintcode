/**
 * Created by Administrator on 2016/5/28.
 */
public class ConvertSortedListtoBalancedBST {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode p = root;
        for (int i = 2; i < 4; i++) {
            ListNode listNode = new ListNode(i);
            p.next = listNode;
            p = p.next;
        }
//        sortedListToBST(root);
        head = root;
        printTree(sortedListToBST(root));
    }
    static ListNode currentHead = null;
    TreeNode buildTree(int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode left = buildTree(start, mid-1);
        TreeNode root = new TreeNode(currentHead.val);
        root.left = left;
        currentHead = currentHead.next;
        root.right = buildTree(mid + 1, end);
        return root;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        if (head == null) return null;
        ListNode ph = head;
        while (ph != null) {
            len++;
            ph = ph.next;
        }
        return helper(0, len - 1);
    }
    static ListNode head = null;
    public static TreeNode helper(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode leftTree = helper(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = leftTree;
        head = head.next;
        root.right = helper(mid + 1, end);
        return root;
    }
    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
}
