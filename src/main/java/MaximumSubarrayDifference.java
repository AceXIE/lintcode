/**
 * Created by Administrator on 2016/8/7.
 */
public class MaximumSubarrayDifference {
    public static void main(String[] args) {
        int[] nums = {-5,3,-4,0,0,0,-1,20,1,1,-1,-1,-1,-1,-1};//{1,2,-3,1};
        System.out.print(maxDiffSubArrays(nums));
    }
    public static int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] leftMin = new int[len];
        int[] leftMax = new int[len];
        int endMin = nums[0], endMax = nums[0];
        leftMax[0] = nums[0];
        leftMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            endMax = Math.max(endMax + nums[i], nums[i]);
            leftMax[i] = Math.max(leftMax[i - 1], endMax);

            endMin = Math.min(endMin + nums[i], nums[i]);
            leftMin[i] = Math.min(leftMin[i - 1], endMin);
        }
        endMax = nums[len - 1];
        endMin = nums[len - 1];
        int[] rightMin = new int[len];
        int[] rightMax = new int[len];
        rightMin[len - 1] = nums[len - 1];
        rightMax[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            endMax = Math.max(nums[i], endMax + nums[i]);
            rightMax[i] = Math.max(rightMax[i + 1], endMax);

            endMin = Math.min(nums[i], endMin + nums[i]);
            rightMin[i] = Math.min(rightMin[i + 1], endMin);
        }
        int maxDiff = 0;
        for (int i = 0; i < len - 1; i++) {
            if (maxDiff < Math.abs(leftMax[i] - rightMin[i + 1])) {
                maxDiff = Math.abs(leftMax[i] - rightMin[i + 1]);
            }
            if (maxDiff < Math.abs(leftMin[i] - rightMax[i + 1])) {
                maxDiff = Math.abs(leftMin[i] - rightMax[i + 1]);
            }
        }
        return maxDiff;
    }

}
