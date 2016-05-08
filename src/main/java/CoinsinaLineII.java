/**
 * Created by Administrator on 2016/5/8.
 */
public class CoinsinaLineII {
    public static void main(String[] args) {
        int[] A = {1,2,2};
        System.out.print(firstWillWin(A));
    }
    public static boolean firstWillWin(int[] values) {
        if (values.length <= 2) return true;
        int len = values.length;
        int[] dp = new int[values.length + 1];
        dp[len] = 0;
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 2] + values[len - 1];
        dp[len - 3] = values[len - 3] + values[len - 2];
        for (int i = len - 4; i >= 0; i++) {
            dp[i] = values[i] + Math.min(dp[i + 2], dp[i + 3]);
            dp[i] = Math.max(dp[i], values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]));
        }
        int sum = 0;
        for (int t:values) {
            sum += t;
        }
        return dp[0] > sum - dp[0];
    }
}
