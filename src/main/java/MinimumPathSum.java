/**
 * Created by Administrator on 2016/4/15.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2},
                {1,1}
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
        };
        System.out.print(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }
}
