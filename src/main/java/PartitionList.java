/**
 * Created by Administrator on 2016/5/7.
 */
public class PartitionList {
    public static void main(String[] args) {
        int[] val = {1,4,3,2,5,2}; int x = 3;
        ListNode head = new ListNode(1);
        ListNode phead = head;
        for (int i = 1; i < val.length; i++) {
            ListNode listNode = new ListNode(val[i]);
            phead.next = listNode;
            phead = phead.next;
        }
//        printListNode(head);
        printListNode(partition(head, x));
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode phead = head;
        ListNode smallhead = new ListNode(0);
        ListNode bighead = new ListNode(0);
        ListNode pSmall = smallhead, pBig = bighead;
        while (phead != null) {
            if (phead.val < x) {
                smallhead.next = phead;
                phead = phead.next;
                smallhead = smallhead.next;
                smallhead.next = null;
            } else {
                bighead.next = phead;
                phead = phead.next;
                bighead = bighead.next;
                bighead.next = null;
            }
        }
        smallhead.next = pBig.next;
        return pSmall.next;
    }
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
