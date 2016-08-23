import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/23.
 */
public class WiggleSortII {

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        for (int i:nums)
            System.out.print(i + ",");
    }

    public static void wiggleSort(int[] nums) {
        if (nums == null) return;
        Arrays.sort(nums);
        int len = nums.length;
        int l = (len + 1)>> 1, r = len - 1;
        l--;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) {
                tmp[i] = nums[l];
                l--;
            } else {
                tmp[i] = nums[r];
                r--;
            }
        }
        for (int i = 0; i < len; i++) {
            nums[i] = tmp[i];
        }
    }
}
