/**
 * Created by Administrator on 2016/8/17.
 */
public class SegmentTreeQueryII {
    //区间相等，直接返回
    //相交，递归返回左右Count
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null) return 0;
        if (start <= root.start && root.end <= end) {
            return root.max;
        }
        int mid = root.start + (root.end - root.start)/2;
        int lCount = 0, rCount = 0;
        if (start <= mid) {
            lCount = query(root.left, start, Math.min(mid, end));
        }
        if (mid < end) {
            rCount = query(root.right, Math.max(mid + 1, start), end);
        }
        return lCount + rCount;
    }
}
