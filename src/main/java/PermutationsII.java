import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Administrator on 2016/8/11.
 */
public class PermutationsII {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int[] n = {1,2,2};
        for (int i : n) {
            nums.add(i);
        }
        ArrayList<ArrayList<Integer>> ans = permuteUnique(nums);
        for (ArrayList<Integer> arrayList : ans) {
            System.out.println(arrayList);
        }
    }
    public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(nums);
        ArrayList<Integer> tmp = new ArrayList<>();
//        helper(res, tmp, nums, 0);//递归
        withoutRec(res, nums);
        return res;
    }
    public static void withoutRec(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums) {
        int len = nums.size();
//        Collections.sort(nums);
        res.add(nums);
        nums = new ArrayList<>(nums);
        int i = 0, j = 0;
        while (true) {
            for (i = len - 2; i >= 0; i--) {
                if (nums.get(i) < nums.get(i + 1)) {
                    break;
                }
            }
            if (i <= -1) return;
            for (j = len - 1; j > i; j--) {
                if (nums.get(j) > nums.get(i)) {
                    break;
                }
            }
            Collections.swap(nums, i, j);
            Collections.reverse(nums.subList(i + 1, len));
            res.add(nums);
            nums = new ArrayList<>(nums);
        }
    }
    /***
     * 递归
     * @param res
     * @param tmp
     * @param nums
     * @param index
     */
    public static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, ArrayList<Integer>nums, int index) {
        int len = nums.size();
        if (index == len) {
            ArrayList<Integer> t = new ArrayList<>(tmp);
            res.add(t);
            return;
        }
        for (int i = index; i < len; i++) {
            if (i > index && nums.get(i) == nums.get(index)) {
                continue;
            } else {
                Collections.swap(nums, index, i);
            }
            tmp.add(nums.get(index));
            helper(res, tmp, nums, index + 1);
            tmp.remove(tmp.size() - 1);
        }
        Collections.sort(nums.subList(index, nums.size()));
    }
}
