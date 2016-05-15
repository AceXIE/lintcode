/**
 * Created by Administrator on 2016/5/15.
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode p = root;
        ListNode l1 = new ListNode(3); ListNode l2 = new ListNode(2); ListNode l3 = new ListNode(0);
        p.next = l1;l1.next = l2; l2.next = l3;
        printListNode(insertionSortList(root));
    }

    /***
     * 借助helper来实现
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode helper = new ListNode(-1);
        ListNode pre = helper;
        while (cur != null) {
            ListNode next = cur.next;
            pre = helper;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }
    public static void printListNode(ListNode root) {
        while (root != null) {
            System.out.print(root.val);
            root = root.next;
        }
    }
}
