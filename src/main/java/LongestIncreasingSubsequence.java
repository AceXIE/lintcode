/**
 * Created by Administrator on 2016/6/1.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1};
        System.out.print(longestIncreasingSubsequence(nums));
    }
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int max = 0;
        int[] longest = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longest[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i] && longest[i] < longest[j] + 1) {
                    longest[i] = longest[j] + 1;
                    if (longest[i] >= max) {
                        max = longest[i];
                    }
                }
            }
        }
        return max;
    }
}
