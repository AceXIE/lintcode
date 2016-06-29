import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/29.
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 * 拓扑图的BFS，DFS
 */
public class TopologicalSorting {

    //BFS
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> arrayList = new ArrayList<DirectedGraphNode>();
        if (graph.size() == 0) return arrayList;
        HashMap<DirectedGraphNode, Set<DirectedGraphNode>> hashMap = new HashMap<DirectedGraphNode, Set<DirectedGraphNode>>();
        for (DirectedGraphNode node : graph) {
            hashMap.put(node, new HashSet<DirectedGraphNode>());
        }
        for (DirectedGraphNode each : graph) {
            for (int i = 0; i < each.neighbors.size(); i++) {
                hashMap.get(each.neighbors.get(i)).add(each);//是谁指向我
            }
        }
        while (graph.size() > 0) {
            int index = 0;
            while (index < graph.size()) {
                DirectedGraphNode cur = graph.get(index);
                if (hashMap.get(cur).size() == 0) {//没有指向我的，说明入度为0
                    arrayList.add(cur);
                    graph.remove(index);
                    for (DirectedGraphNode elem : graph) {
                        if (hashMap.get(elem).contains(cur)) {
                            hashMap.get(elem).remove(cur);
                        }
                    }
                } else {
                    index++;
                }
            }
        }
        return arrayList;
    }
}
