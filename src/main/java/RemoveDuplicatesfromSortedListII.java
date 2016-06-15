/**
 * Created by Administrator on 2016/6/15.
 */
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);
        l5.next = l6;
        l4.next = l5;
        l3.next = l4;
        l2.next = l3;
        root.next = l2;
        deleteDuplicates(root);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            boolean dup = false;
            while (cur.next != null && cur.val == cur.next.val) {
                dup = true;
                cur = cur.next;
            }
            if (dup) {
                cur = cur.next;
                continue;
            }
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur;
        return dummy.next;
    }
}
