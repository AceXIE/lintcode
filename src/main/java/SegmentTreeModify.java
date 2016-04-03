/**
 * Created by xk on 2016/4/3.
 */
public class SegmentTreeModify {
    public void modify(SegmentTreeNode root, int index, int value) {
        if (root == null) return;
        if (root.start > index || root.end < index) {
            return;
        }
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        int mid = (root.start + root.end)/2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);

    }
}
