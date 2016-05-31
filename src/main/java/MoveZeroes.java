/**
 * Created by Administrator on 2016/5/31.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i);
        }
    }
    public static void moveZeroes(int[] nums) {
        if (nums == null) return;
        if (nums.length == 0) return;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == 0) {
                nums[start] = nums[end];
                nums[end] = 0;
                while (nums[end] == 0) {
                    end--;
                    if (start>end) return;
                }
                start++;
            }
        }
    }
}
