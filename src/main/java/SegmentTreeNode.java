/**
 * Created by xk on 2016/4/3.
 */
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}
