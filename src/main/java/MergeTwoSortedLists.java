/**
 * Created by xk on 2016/3/29.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode res = new ListNode(0);
        ListNode pr = res;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pr.next = p1;
                p1 = p1.next;
            } else {
                pr.next = p2;
                p2 = p2.next;
            }
            pr = pr.next;
        }
        if (p1 == null) {
            pr.next = p2;
        }
        if (p2 == null) {
            pr.next = p1;
        }
        return res.next;
    }
}
