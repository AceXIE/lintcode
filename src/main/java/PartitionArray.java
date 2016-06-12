import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/12.
 */
public class PartitionArray {
    public static void main(String[] args) {
        int[] nums = {3,2,2,1};
        int k = 2;
        System.out.print(partitionArray(nums,k));
    }
    public static int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int pa = 0, pb = nums.length - 1;
        while (pa < pb) {
            while (pa < len && nums[pa] < k) pa++;
            while (pb >= 0 && nums[pb] >= k) pb--;
            if (pa < pb) {
                int tmp = nums[pa];
                nums[pa] = nums[pb];
                nums[pb] = tmp;
                pa++;pb--;
            }
        }
        int res = len;//如果都小于k的话，需要返回长度
        for (int i = 0; i < len; i++) {
            if (nums[i] >= k) {
                res = i;
                break;
            }
        }
        return res;
    }
}
