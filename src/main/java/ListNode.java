/**
 * Created by xk on 2016/3/25.
 */
public class ListNode {
    public int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
