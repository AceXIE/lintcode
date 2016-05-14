/**
 * Created by Administrator on 2016/5/14.
 * 动态规划问题
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.print(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max_local = nums[0];
        int min_local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max_cp = max_local;
            max_local = Math.max(Math.max(nums[i]*max_local, nums[i]),nums[i]*min_local);
            min_local = Math.min(Math.min(nums[i]*max_cp, nums[i]), nums[i]*min_local);
            global = Math.max(global,max_local);
        }
        return global;
    }
}
