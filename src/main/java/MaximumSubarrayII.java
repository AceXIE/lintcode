import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/7.
 */
public class MaximumSubarrayII {
    public static void main(String[] args) {
        int[] num = {1, 3, -1, 2, -1, 2};
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i : num) {
            nums.add(i);
        }
        System.out.print(maxTwoSubArrays(nums));
    }
    public static int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        int len = nums.size();
        int[] leftMin = new int[len];
        int[] leftMax = new int[len];
        int endMin = nums.get(0), endMax = nums.get(0);
        leftMax[0] = nums.get(0);
        leftMin[0] = nums.get(0);
        for (int i = 1; i < len; i++) {
            endMax = Math.max(endMax + nums.get(i), nums.get(i));
            leftMax[i] = Math.max(leftMax[i - 1], endMax);
        }
        endMax = nums.get(len - 1);
        endMin = nums.get(len - 1);
        int[] rightMin = new int[len];
        int[] rightMax = new int[len];
        rightMin[len - 1] = nums.get(len - 1);
        rightMax[len - 1] = nums.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            endMax = Math.max(nums.get(i), endMax + nums.get(i));
            rightMax[i] = Math.max(rightMax[i + 1], endMax);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            if (maxSum < leftMax[i] + rightMax[i + 1]) {
                maxSum = leftMax[i] + rightMax[i + 1];
            }
        }
        return maxSum;
    }
}
