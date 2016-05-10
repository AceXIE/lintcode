/**
 * Created by Administrator on 2016/5/10.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode p = root;
        for (int i = 2; i <= 5; i++) {
            ListNode listNode = new ListNode(i);
            p.next = listNode;
            p = p.next;
        }
        ListNode res = reverseBetween(root, 2, 4);
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode first = pre;
        int km = m - 1;
        while (km > 0) {
            first = first.next;
            km--;
        }
        ListNode reversePre = first.next;
        //m~n
        ListNode tmpHead = null;
        ListNode tmpNext = null;
        ListNode node = first.next;
        km = n - m + 1;
        while (km > 0) {
            tmpHead = node;
            node = node.next;
            tmpHead.next = tmpNext;
            tmpNext = tmpHead;
            km--;
        }
        first.next = tmpHead;
        reversePre.next = node;
        return pre.next;
    }
}
