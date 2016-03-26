/**
 * Created by xk on 2016/3/26.
 */
public class DeleteNodeintheMiddleofSinglyLinkedList {
    /***
     * 由于只给出了需要删除的节点，
     * 这里需要把此节点的下一节点值复制，然后删除下一节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
