/**
 * Created by xk on 2016/4/3.
 */
public class SegmentTreeQuery {
    public static int query(SegmentTreeNode root, int start, int end) {
        if (root.end < start || root.start > end || start > end) {
            return Integer.MIN_VALUE;
        }
        if (root.start >= start && root.end <= end) {
            return root.max;
        }
        int mid = (root.start + root.end) / 2;
        int leftmax = query(root.left, start, Math.min(mid, end));
        int rightmax = query(root.right, Math.max(mid, start), end);
        return Math.max(leftmax, rightmax);
    }

}
