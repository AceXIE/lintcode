/**
 * Created by Administrator on 2016/5/2.
 * 动态规划问题
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.print(numDistinct(s,t));
    }

    /***
     *
     * @param S
     * @param T
     * @return
     */
    public static int numDistinct(String S, String T) {
        int M = S.length(), N = T.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= M; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[M][N];
    }
}
