/**
 * Created by Administrator on 2016/8/13.
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode p = head;
//        for (int i = 2; i < 6; i++) {
//            p.next = new ListNode(i);
//            p = p.next;
//        }
        System.out.print(rotateRight(head, 0));
    }
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head, slow = head, p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (len == 0) return null;
        k = k%len;
        if (k == 0) return head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode ans = slow.next;
        slow.next = null;
        fast.next = head;
        return ans;
    }
}
