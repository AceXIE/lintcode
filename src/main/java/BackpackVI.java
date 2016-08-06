import java.util.Arrays;
import java.util.Vector;

/**
 * Created by Administrator on 2016/8/6.
 */
public class BackpackVI {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.print(backPackVI(nums,4));
    }
    public static int backPackVI(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int a : nums) {
                if (a > i) {
                    break;
                }
                dp[i] += dp[i - a];
            }
        }
        return dp[target];
    }
}
