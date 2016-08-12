

/**
 * Created by Administrator on 2016/8/12.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 4; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        reorderList(head);
        System.out.print(head);
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //快慢指针，找中间
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) fast = fast.next;
            else break;
            slow = slow.next;
        }
        ListNode head1 = head, head2 = slow.next;
        slow.next = null;

        //反转后半部分
        ListNode cur = head2;
        ListNode next = cur.next;
        cur.next = null;
        while (next != null) {
            ListNode t = next.next;
            next.next = cur;
            cur = next;
            next = t;
        }
        head2 = cur;
        //合并
        ListNode p1 = head1, p2 = head2;
        while (p2 != null) {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        }
        return;
    }
}
