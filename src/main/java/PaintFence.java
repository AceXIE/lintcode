/**
 * Created by Administrator on 2016/6/10.
 */
public class PaintFence {
    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.print(numWays(n,k));
    }
    public static int numWays(int n, int k) {
        int[] dp = new int[n];
        if (n == 0) return 0;
        else if (n == 1) return k;
        else if (n == 2) return k*k;

        dp[0] = k;
        dp[1] = k*k;
        for (int i = 2; i < n; i++) {
            dp[i] = (k - 1)*dp[i - 1] + (k - 1)*dp[i - 2];//第i个或者与i-1不同，或者与i-2不同
        }
        return dp[n - 1];
    }
}
