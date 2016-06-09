/**
 * Created by Administrator on 2016/6/9.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        l3.next = l4;
        l2.next = l3;
        head.next = l2;
        System.out.print(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow.next = reverse(slow.next);
            slow = slow.next;
        } else {
            slow = reverse(slow);
        }
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
//        ListNode reverseNode = reverse(head);
//        while (head != null && reverseNode != null) {
//            if (head.val != reverseNode.val) {
//                return false;
//            }
//            head = head.next;
//            reverseNode = reverseNode.next;
//        }
        return true;
    }
    private static ListNode reverse(ListNode head1) {
        ListNode head = head1;
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy.next;
        ListNode cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pre.next;
        }
        return dummy.next;
    }
}
