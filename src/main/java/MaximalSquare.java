import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/6.
 */
public class MaximalSquare {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}};
        System.out.print(maxSquare(matrix));
    }
    public static int maxSquare(int[][] matrix) {
        if (matrix == null) return 0;
        if (matrix.length == 0 || matrix[0].length == 0) return 1;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
