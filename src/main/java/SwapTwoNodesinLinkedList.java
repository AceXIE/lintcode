/**
 * Created by Administrator on 2016/8/24.
 */
public class SwapTwoNodesinLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print(swapNodes(head, 2, 4));

    }

    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null) return null;
        ListNode p1 = null, p2 = null, pc = new ListNode(-1);
        pc.next = head;
        ListNode pre = pc, cur = head;

        while (cur.next != null) {
            if (cur.next.val == v1 || cur.next.val == v2) {
                if (p1 == null) {
                    p1 = cur.next;
                    pre = cur;
                } else {
                    ListNode t = cur.next.next;
                    p2 = cur.next;
                    pre.next = p2;
                    if (p1 == cur) {
                        p2.next = p1;
                        p1.next = t;
                    } else {
                        p2.next = p1.next;
                        cur.next = p1;
                        p1.next = t;
                    }
                    return pc.next;
                }
            }
            cur = cur.next;
        }
        return  pc.next;
    }
}
