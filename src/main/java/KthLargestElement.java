/**
 * Created by Administrator on 2016/8/5.
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {9,3,2,4,8};
        System.out.print(kthLargestElement(3,nums));
    }
    public static int kthLargestElement(int k, int[] nums) {
//        return helperFind(nums,)
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int left = l, right = r;
            int key = nums[left];
            while (left < right) {
                while (left < right && nums[right] < key) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] >= key) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = key;
            if (left == k - 1) return nums[k - 1];
            else if (left > k - 1) r = left - 1;
            else  l = left + 1;
        }
        return nums[k - 1];
    }
//    public static int helperFind(int[] nums, int k, int i, int j) {
//
//    }
//    public static int partition(int[] nums, int i, int j) {
//
//    }
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
