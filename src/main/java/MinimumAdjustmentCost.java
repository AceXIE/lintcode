import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/27.
 */
public class MinimumAdjustmentCost {
    public static int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null) return 0;
        int len = A.size();
        if (len < 2) return 0;
        int[][] cost = new int[len][100];//从第i个调整到。。。距离
        for (int i = 0; i < 100; i++) {
            cost[0][i] = Math.abs(A.get(0) - (i + 1));//A[0]到i+1的距离
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 100; j++) {
                int diff = Math.abs(A.get(i) - (j + 1));//A[i]调整到j+1的距离
                int upper = Math.min(j + target, 99);
                int lower = Math.max(j - target, 0);
                cost[i][j] = Integer.MAX_VALUE;//从index = i调整到j需要的距离
                for (int k = lower; k <= upper; k++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i - 1][k] + diff);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            ans = Math.min(cost[len - 1][i], ans);
        }
        return ans;
    }
}
