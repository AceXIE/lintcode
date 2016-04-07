import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/7.
 */
public class DirectedGraphNode {
    public int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
