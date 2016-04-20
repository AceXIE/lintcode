/**
 * Created by Administrator on 2016/4/20.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        sortColors(nums);
        for (int t : nums) {
            System.out.print(t);
        }
    }
    public static void sortColors(int[] nums) {
        int i = -1, j = -1;
        for (int p = 0; p < nums.length; p++) {
            int v = nums[p];
            nums[p] = 2;
            if (v == 0) {
                nums[++i] = 1;
                nums[++j] = 0;
            } else if (v == 1) {
                nums[++i] = 1;
            }
        }
    }
}
