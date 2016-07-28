/**
 * Created by Administrator on 2016/7/28.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null ) return null;
        RandomListNode p1 = head, p2 = head.next;
        while (p1 != null) {
            p1.next = new RandomListNode(p1.label);
            p1.next.next = p2;
            p1 = p2;
            if (p2 != null) p2 = p2.next;
        }
        p1 = head;
        p2 = head.next;
        while (p1 != null) {
            if (p1.random == null) p2.random = null;
            else p2.random = p1.random.next;
            p1 = p1.next.next;
            if (p2.next != null) p2 = p2.next.next;
        }
        RandomListNode res = head.next;
        p1 = head;
        p2 = head.next;
        while (p2.next != null) {
            p1.next = p2.next;
            p1 = p2;
            if (p2.next != null) p2 = p2.next;
        }
        p1.next = null;
        p2.next = null;
        return res;
    }
}
