/**
 * Created by xk on 2016/4/3.
 */
public class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
}
