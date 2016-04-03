/**
 * Created by xk on 2016/4/3.
 */
public class SegmentTreeBuild {
    public static SegmentTreeNode build(int start, int end) {
        if (start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) return root;
        int mid = (start + end)/2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        return root;
    }
}
