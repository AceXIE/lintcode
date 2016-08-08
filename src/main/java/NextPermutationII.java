import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/8.
 */
public class NextPermutationII {
    public static void main(String[] args) {
        int[] nums = {2,1,1};//{1,2,4,6,5,3};//{1,3,2,3};
        nextPermutation(nums);
        for (int i: nums)
            System.out.print(i + ",");
    }
    public static void nextPermutation(int[] nums) {
        int peakId = nums.length - 1;
        while (peakId > 0 && nums[peakId - 1] >= nums[peakId]) {
            peakId--;
        }
        peakId--;
        int swId = nums.length - 1;
        if (peakId >= 0) {
            while (nums[peakId] >= nums[swId]) {
                swId--;
            }
            int tmp = nums[swId];
            nums[swId] = nums[peakId];
            nums[peakId] = tmp;
            Arrays.sort(nums,peakId+1, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}
