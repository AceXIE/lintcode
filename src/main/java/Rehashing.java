/**
 * Created by Administrator on 2016/6/19.
 */
public class Rehashing {
    public static ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null) return null;
        int len = hashTable.length;
        if (len == 0) return null;
        int newlen = len * 2;
        ListNode[] newhashTable = new ListNode[newlen];

        for (int i = 0; i < len; i++) {
            ListNode cur = hashTable[i];
            while (cur != null) {
                ListNode listNode = cur;
                cur = cur.next;
                int val = (listNode.val % newlen + newlen) % newlen;
                if (newhashTable[val] == null) {
                    newhashTable[val] = listNode;
                    listNode.next = null;
                } else {//冲突了
                    ListNode p = newhashTable[val];
                    while (p.next != null) p = p.next;
                    p.next = listNode;
                    listNode.next = null;
                }
            }
        }
        return newhashTable;
    }
}
