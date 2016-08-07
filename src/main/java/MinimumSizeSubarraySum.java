/**
 * Created by Administrator on 2016/8/7.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.print(minimumSize(nums, 7));
    }
    public static int minimumSize(int[] nums, int s) {
        if (nums == null) return -1;
        int len = nums.length;
        int fast = 0, slow = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (fast < len && slow < len) {
            while (fast < len && sum < s) {
                sum += nums[fast];
                fast++;
            }
            while (slow <= fast && sum >= s) {
                min = Math.min(min, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
