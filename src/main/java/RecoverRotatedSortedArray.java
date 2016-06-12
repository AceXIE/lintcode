import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/12.
 */
public class RecoverRotatedSortedArray {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (Integer integer : integers) {
            nums.add(integer);
        }
        recoverRotatedSortedArray(nums);
    }
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int index = 0;
        while (index < nums.size() - 1) {
            if (nums.get(index) > nums.get(index + 1)) {
                break;
            }
            index++;
        }
        if (index == nums.size() - 1) return;
        rotateArray(nums, 0, index);
        rotateArray(nums, index + 1, nums.size() - 1);
        rotateArray(nums, 0, nums.size() - 1);
    }
    public static void rotateArray(ArrayList<Integer> nums, int s, int e) {
        int front = s, rear = e;
        if (nums.size() == 0 || s == e) {
            return;
        }
        while (front < rear) {
            int tmp = nums.get(front);
            nums.set(front, nums.get(rear));
            nums.set(rear, tmp);
            front++;rear--;
        }
    }
}
