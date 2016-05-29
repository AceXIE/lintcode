/**
 * Created by Administrator on 2016/5/29.
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.print(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = (obstacleGrid[0][0] == 0?1:0);
        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0?dp[i-1][0]:0);
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 0?dp[0][i-1]:0);
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0?(dp[i-1][j] + dp[i][j-1]):0);
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
