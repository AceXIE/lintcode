import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/30.
 */
public class PreviousPermutation {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);nums.add(3);nums.add(2);nums.add(3);
        ArrayList<Integer> res = previousPermuation(nums);
        for (Integer integer : res) {
            System.out.print(integer);
        }
    }
    //查找自然序列的前一个序列
    public static ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        int peakId = nums.size() -1;
        while (peakId > 0 && nums.get(peakId - 1) <= nums.get(peakId)) {
            peakId--;
        }
        peakId--;//从右到左，递减序列的前一个位置
        if (peakId >= 0) {
            int swapId = peakId + 1;
            while (swapId < nums.size() && nums.get(swapId) < nums.get(peakId)) {
                swapId++;
            }
            swapId--;
            int tmp = nums.get(swapId);
            nums.set(swapId, nums.get(peakId));
            nums.set(peakId, tmp);
        }
        int left = peakId + 1;
        int right = nums.size() - 1;
        while (left < right) {
            int tmp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, tmp);
            left++;right--;
        }
        return nums;
    }
}
