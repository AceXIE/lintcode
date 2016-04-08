/**
 * Created by Administrator on 2016/4/8.
 */
public class BackpackII {
    public static void main(String[] args) {
        int m = 10;
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
        System.out.println(backPackII(m, A, V));
    }
    public static int backPackII(int m, int[] A, int V[]) {
        int[][] dp = new int[A.length + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j < A[i]) {//第i个装不下去
                    dp[i + 1][j] = dp[i][j];
                } else {//能装下
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + V[i]);
                }
            }
        }
        return dp[A.length][m];
    }
}
