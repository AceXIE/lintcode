/**
 * Created by Administrator on 2016/6/12.
 * DP问题
 */
public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {4,1,5,10};
        System.out.print(maxCoins(nums));
    }
    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] nums_cp = new int[len + 2];
        nums_cp[0] = nums_cp[len + 1] = 1;
        for (int i = 1; i < len + 1; i++) {
            nums_cp[i] = nums[i - 1];
        }
        len = nums_cp.length;
        int[][] dp = new int[len][len];
        for (int i = 2; i < len; i++) {//跨度
            for (int l = 0; l < len - i; l++) {
                int r = l + i;
                for (int m = l + 1; m < r; m++) {
                    dp[l][r] = Math.max(dp[l][r], nums_cp[l]*nums_cp[m]*nums_cp[r] + dp[l][m] + dp[m][r]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
