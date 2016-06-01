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
        if (nums.length < 2) return;
        int start = 0, end = 1;
        while (end < nums.length) {
            while (nums[start] == 0) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                end++;
                if (end >= nums.length) return;
            }
            start++;
            end = start+1;
        }
    }
}
