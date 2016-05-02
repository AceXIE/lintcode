/**
 * Created by Administrator on 2016/5/2.
 * 允许出现两次
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] A = {1,1,1,2,2,3};
        System.out.print(removeDuplicates(A));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;
        int pa = 0, pb = 1;
        while (pb < nums.length) {
            if (nums[pa] != nums[pb]) {
                nums[++pa] = nums[pb++];
            } else {
                nums[++pa] = nums[pb];
                while (nums[pa] == nums[pb]) {
                    pb++;
                    if (pb >= nums.length) return pa + 1;
                }
            }
        }
        return pa + 1;
    }
}
