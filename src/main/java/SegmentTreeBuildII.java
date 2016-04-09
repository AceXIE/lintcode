/**
 * Created by Administrator on 2016/4/9.
 */
public class SegmentTreeBuildII {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4};
        System.out.println(build(A).toString());
    }
    public static SegmentTreeNode build(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        return helper(0, A.length - 1, A);
    }
    public static SegmentTreeNode helper(int start, int end, int[] A) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            int mid = (start + end) / 2;
            root.left = helper(start, mid, A);
            root.right = helper(mid + 1, end, A);
        }
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }
}
