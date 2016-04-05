/**
 * Created by Administrator on 2016/4/5.
 */
public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {
                {14,2,11},
                {11,14,5},
                {14,3,10}};
        System.out.println(minCost(costs));
    }
    public static int minCost(int[][] costs) {
        int ans = 0;
        if (costs != null && costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        ans = Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
        return ans;
    }
}
