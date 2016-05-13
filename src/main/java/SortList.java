/**
 * Created by Administrator on 2016/5/13.
 */
public class SortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode p = root;
        p.next = l1;
        l1.next = l2;
        print(sortList(root));
    }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode nextListNode = middle.next;
        middle.next = null;//断开
        return mergeList(sortList(head), sortList(nextListNode));
    }
    public static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode mergeList(ListNode a, ListNode b) {
        ListNode listNode = new ListNode(0);
        ListNode curr = listNode;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        curr.next = (a!=null?a:b);
        return listNode.next;
    }
    public static void print(ListNode root) {
        ListNode p = root;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }

}
