/**
 * Created by Administrator on 2016/5/15.
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        int n = 1;
//        for (int i = 2; i < 6; i++) {
//            ListNode node = new ListNode(i);
//            p.next = node;
//            p = p.next;
//        }
//        printListNode(head);
//        int n = 2;
        printListNode(removeNthFromEnd(head, n));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) return head;
        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode pFast = helper;
        ListNode pSlow = helper;
        while (n > 0) {
            pFast = pFast.next;
            n--;
        }
        ListNode pre = pSlow;
        while (pFast != null) {
            pFast = pFast.next;
            pre = pSlow;
            pSlow = pSlow.next;
        }
        pre.next = pre.next.next;
        return helper.next;
    }
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
