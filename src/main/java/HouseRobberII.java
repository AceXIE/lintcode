/**
 * Created by Administrator on 2016/4/27.
 */
public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {3, 6, 4};
        System.out.print(houseRobber2(nums));
    }

    /***
     * 查找局部最优，包括第一个 或者 包括最后一个
     * 然后，找到全局最优
     * @param nums
     * @return
     */
    public static int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] ans = new int[nums.length];
        return Math.max(help(nums, 0, nums.length - 2), help(nums, 1, nums.length - 1));
    }

    /***
     * 查找从s到e的最大
     * @param nums
     * @param s
     * @param e
     * @return
     */
    public static int help(int[] nums, int s, int e) {
        int length = e - s + 1;
        int[] dp = new int[length];
        dp[0] = nums[s];
        dp[1] = Math.max(nums[s], nums[s + 1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[s + i]);
        }
        return dp[length - 1];
    }
}
