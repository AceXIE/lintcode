import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/9.
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2};
        wiggleSort1(nums);
    }

    /***
     * 摇摆
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[j];
            } else {
                if (nums.length % 2 == 0) {
                    res[i] = nums[j + nums.length/2];
                } else {
                    res[i] = nums[j + nums.length/2 + 1];//奇数的话，就中间截断往后移动一个
                }
                j++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
            System.out.print(nums[i]);
        }
    }

    /***
     * 贪婪
     * @param nums
     */
    public static void wiggleSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i-1] > nums[i]) || (i % 2 ==0 && nums[i] > nums[i - 1])) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
