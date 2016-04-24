/**
 * Created by Administrator on 2016/4/20.
 */
public class SortColorsII {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1, 4}; int k =4;
//        sortColorsII(nums, k);
       sortColoursIIUsingJustSort(nums,k);
        for (int t : nums) {
            System.out.print(t);
        }
    }

    /***
     * 就是计数排序，O(N),O(k)
     * @param colors
     * @param k
     */
    public static void sortColoursIIUsingJustSort(int[] colors, int k) {
        int[] count = new int[k];
        for (int i = 0; i < k; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < colors.length; i++) {
            count[colors[i] - 1]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count[i]; j++) {
                colors[index++] = i + 1;
            }
        }

    }
    public static void sortColorsII(int[] nums, int k) {
        if (nums == null || k <= 1 || nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }

    /***
     * 快排
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = r;
        int pos = partition(nums, l, r, pivot);
        quickSort(nums, l, pos - 1);
        quickSort(nums, pos + 1, r);
    }
    public static int partition(int[] nums, int start, int end, int pivot) {
        int l = start, r = end;
        while (true) {
            while (l < r && nums[l] < nums[pivot]) {
                l++;
            }
            while (l < r && nums[r] >= nums[pivot]) {
                r--;
            }
            if (l == r) break;
            swap(nums, l, r);
        }
        swap(nums, l, end);
        return l;
    }
    public static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
