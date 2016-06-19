import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/19.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<Integer, UndirectedGraphNode> checker = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node, checker);
    }
    private UndirectedGraphNode clone (UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> checker) {
        if (checker.containsKey(node.label)) {
            return checker.get(node.label);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        checker.put(newNode.label, newNode);
        for (UndirectedGraphNode tmpNode : node.neighbors) {
            newNode.neighbors.add(clone(tmpNode, checker));
        }
        return newNode;
    }
}
