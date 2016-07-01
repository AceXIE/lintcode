/**
 * Created by Administrator on 2016/7/1.
 */
public class Triangle {
    public static void main(String[] args) {
        int [][] triangle = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}};
        System.out.print(minimumTotal(triangle));
    }
    public static int minimumTotal(int[][] triangle) {
        if (triangle == null) return 0;
        int len = triangle.length;
        if (len == 1) return triangle[0][0];
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = triangle[len - 1][i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];

    }
}
