/**
 * Created by Administrator on 2016/5/3.
 */
public class SwapNodesinPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode root = head;
        for (int i = 2; i <= 4; i++) {
            ListNode next = new ListNode(i);
            head.next = next;
            head = head.next;
        }
        head = swapPairs(root);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode bhead = new ListNode(0);//头节点前的哨兵
        bhead.next = head;//标记头节点
        ListNode pre = bhead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nnext = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = nnext;
            cur = nnext;
            pre = pre.next.next;
        }
        if (cur != null) pre.next = cur;

        return bhead.next;
    }
}
