/**
 * Created by Administrator on 2016/4/26.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
        System.out.print(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int pa = 0, pb = 1;
        if (nums.length == 0 || nums == null) return 0;
        while (pb < nums.length) {
            while (nums[pa] == nums[pb]) {
                pb++;
                if (pb > nums.length - 1) return pa + 1;
            }
            nums[++pa] = nums[pb++];
        }
        return pa + 1;
    }
}
