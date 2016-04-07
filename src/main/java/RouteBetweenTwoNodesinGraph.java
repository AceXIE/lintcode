import java.util.*;

/**
 * Created by Administrator on 2016/4/7.
 */
public class RouteBetweenTwoNodesinGraph {
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        if (s == t) {
            return true;
        }
        queue.offer(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode tmp = queue.poll();//弹出，并删除第一个，相当于pop
            for (int i = 0; i < tmp.neighbors.size(); i++) {
                if (tmp.neighbors.get(i) == t) {
                    return true;
                } else {
                    queue.offer(tmp.neighbors.get(i));
                }
            }
        }
        return false;
    }
}
