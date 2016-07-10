/**
 * Created by Administrator on 2016/7/10.
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,4,5,3};
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            p.next = listNode;
            p = p.next;
        }
        System.out.println(head);
        System.out.print(removeElements(head, 3));
    }
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode p = head;
        ListNode dummy = new ListNode(-1);
        ListNode lastP = dummy;
        while (p != null) {
            if (p.val == val) {
                p = p.next;
                continue;
            }
            lastP.next = p;
            p = p.next;
            lastP = lastP.next;
        }
        lastP.next = null;
        return dummy.next;
    }
}
