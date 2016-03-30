/**
 * Created by xk on 2016/3/30.
 * 动态规划的问题，DP
 * 维护局部最优，和全局最优，找到关系式。
 */
public class MaximumSubarray {
    public void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int global = nums[0];
        int local = nums[0];
        for (int i = 1; i < nums.length; i++) {
           local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }
}
