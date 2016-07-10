import sun.plugin.javascript.navig.LinkArray;

/**
 * Created by Administrator on 2016/7/10.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = new int[] {7,1,6};
        int[] nums2 = new int[] {5,9,2};

        ListNode l1 = new ListNode(-1);
        ListNode p1 = l1;
        ListNode l2 = new ListNode(-1);
        ListNode p2 = l2;
        for (int i = 0; i < nums1.length; i++) {
            ListNode l = new ListNode(nums1[i]);
            p1.next = l;
            p1 = p1.next;
        }
        for (int i = 0; i < nums2.length; i++) {
            ListNode l = new ListNode(nums2[i]);
            p2.next = l;
            p2 = p2.next;
        }
        System.out.print(addLists(l1.next, l2.next));
    }

    public static ListNode addLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, pa = ans;
        int carry = 0, n1, n2;
        while (p1 != null && p2 != null) {
            n1 = p1.val;
            n2 = p2.val;
            ListNode listNode = new ListNode((n1 + n2 + carry)%10);
            carry = (n1 + n2 + carry)/10;
            pa.next = listNode;
            pa = pa.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            n1 = p1.val;
            ListNode listNode = new ListNode((n1 + carry)%10);
            carry = (n1 + carry)/10;
            pa.next = listNode;
            pa = pa.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            n2 = p2.val;
            ListNode listNode = new ListNode((n2 + carry)%10);
            carry = (n2 + carry)/10;
            pa.next = listNode;
            pa = pa.next;
            p2 = p2.next;
        }
        if (carry != 0) {
            ListNode listNode = new ListNode(carry);
            pa.next = listNode;
        }
        return ans.next;
    }

}
