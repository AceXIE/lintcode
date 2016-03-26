/**
 * Created by xk on 2016/3/25.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        int la = 0, lb = 0;
        while (pa != null) {
            la++;
            pa = pa.next;
        }
        while (pb != null) {
            lb++;
            pb = pb.next;
        }
        if (la <= lb) {//A链表比较短
            int lc = lb - la;
            pa = headA;
            pb = headB;
            while (lc != 0) {
                pb = pb.next;
                lc--;
            }
        } else {//B链表短，反过来
            int lc = la - lb;
            pa = headA;
            pb = headB;
            while (lc != 0) {
                pa = pa.next;
                lc--;
            }
        }
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
}
