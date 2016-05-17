import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */
public class ReverseNodesinkGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 6; i++) {
            ListNode l = new ListNode(i);
            p.next = l;
            p = p.next;
        }
        printListNode(head);
        int k = 2;
        printListNode(reverseKGroup2(head,k));
    }
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        if (cnt == k) {
            cur = reverseKGroup2(cur, k);
            while (0 <= --cnt) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newhead = new ListNode(0);
        ListNode pnewhead = newhead;
        ListNode cur = head;
        ListNode start, end;
        while (cur != null) {
            int cout = 0;
            start = cur;
            while (cur != null && cout < k - 1) {//检查是否是一个group
                cur = cur.next;
                cout++;
            }
            if (cout == k-1 && cur != null) {
                end = cur;
                cur = cur.next;
                reverseGroup(start, end);
                pnewhead.next = start;
                pnewhead = end;
                end.next = null;
                cout = 0;
            } else {
                pnewhead.next = start;
            }
        }
        return pnewhead.next;
    }
    public static void reverseGroup(ListNode start, ListNode end) {
        if (start == null || start.next == null || start == end) return;
        ListNode copystart = start;
        ListNode pre = start, cur = start.next, next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        start = cur;
        end = copystart;
    }
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
