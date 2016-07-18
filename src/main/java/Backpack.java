import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Backpack {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 7};
        System.out.print(backPack(12, A));
    }
    public static int backPack(int m, int[] A) {
        if (A == null ) return 0;
        if (A.length == 0) return 0;
        int len = A.length;
        boolean[][] dp = new boolean[len + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j < A[i - 1]) {//放不下
                    dp[i][j] = dp[i - 1][j];
                } else { //能放下，可以选择放或者不放
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                }
            }
        }
        for (int i = dp[0].length - 1; i >= 0; i--) {
            if (dp[dp.length - 1][i]) {
                return i;
            }
        }
        return 0;
    }
}
