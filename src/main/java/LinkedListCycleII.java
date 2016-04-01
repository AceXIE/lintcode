/**
 * Created by Administrator on 2016/4/1.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (slow == null || fast == null) return null;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
            else return null;
        } while (fast != slow);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
