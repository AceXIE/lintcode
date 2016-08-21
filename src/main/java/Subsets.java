import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/21.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ArrayList<ArrayList<Integer>> a = subsets(nums);
        for (ArrayList<Integer> b : a) {
            System.out.println(b);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        res.add(tmp);
        if (nums == null) return res;
        Arrays.sort(nums);
//        for (int i = 1; i <= nums.length; i++) {
//            tmp.clear();
//            helper(res, tmp, nums, 0, i);
//        }
        helper2(res, tmp, nums, 0, nums.length - 1);//递归2
        return res;
    }
    public static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] nums, int start, int end) {
        if (end == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(res, tmp, nums, i + 1, end);
            tmp.remove(tmp.size() - 1);
        }
    }

    //递归2
    public static void helper2(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] nums, int start, int end) {
        if (start == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        helper2(res, tmp, nums, start + 1, end);
        tmp.add(nums[start]);
        helper2(res, tmp, nums, start + 1, end);
        tmp.remove(tmp.size() - 1);
    }
}
