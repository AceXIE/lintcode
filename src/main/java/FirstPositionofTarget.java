/**
 * Created by Administrator on 2016/4/25.
 */
public class FirstPositionofTarget {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 10};
//        int[] nums = {1,4,4,5,7,7,8,9,9,10};
//        int[] nums = {4,5,9,9,12,13,14,15,15,18};
        int target = 1;
        System.out.print(binarySearch(nums, target));
    }
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;

        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l + 1 < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l] == target) {
            ans = l;
        }
        if (nums[r] == target) {
            ans = r;
        }
        return ans;
    }
}
