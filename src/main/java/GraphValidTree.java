import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/29.
 */
public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}};
        int n = 5;
        System.out.print(validTree(n, edges));
    }
    public static boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return false;
        if (edges[0] == null || edges[0].length == 0) return false;

        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int root1 = find(root, edges[i][0]);
            int root2 = find(root, edges[i][1]);
            if (root1 == root2) {
                return false;
            }
            root[root2] = root1;
        }
        return edges.length == n - 1;
    }
    public static int find(int[] root, int e) {
        if (root[e] == e) {
            return e;
        } else {
            return find(root, root[e]);
        }
    }
}
