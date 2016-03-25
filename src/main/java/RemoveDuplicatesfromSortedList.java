/**
 * Created by xk on 2016/3/25.
 */
public class RemoveDuplicatesfromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode p = head.next;
        while (p != null) {
            if (cur.val == p.val) {
                cur.next = p.next;
                p = p.next;
            } else {
                cur = p;
                p = p.next;
            }
        }
        return head;
    }
}
