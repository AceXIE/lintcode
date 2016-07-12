import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Median {
    public static void main(String[] args) {
        int[] nums = {4,5,1,2,3};
        System.out.print(median(nums));
    }
    public static int median(int[] nums) {
        if (nums == null|| nums.length == 0) return 0;
        Arrays.sort(nums);
        return nums[(nums.length - 1)/2];
    }
}
