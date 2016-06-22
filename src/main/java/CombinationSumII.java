import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/21.
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] num = {7,1,2,5,1,6,10};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(num, target);
        for (List<Integer> integerList : lists) {
            for (Integer integer : integerList) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        if (num == null)
        {
            res.add(list);
            return res;
        }

        Arrays.sort(num);
        dfs(num, 0, target, list, res);
        return res;
    }
    public static void dfs(int[] nums, int start, int target, List<Integer> list, List<List<Integer>> result)
    {
        if (target == 0)
        {
            result.add(new LinkedList<Integer>(list));
            return;
        }
        if (start > nums.length || nums[0] > target)
        {
            return;
        }
        int i = start;
        while (i < nums.length)
        {
            if (nums[i] <= target)
            {
                list.add(nums[i]);
                dfs(nums, i + 1, target - nums[i], list, result);
                list.remove(list.size() - 1);
                while (i < (nums.length - 1) && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            i++;
        }
    }
}
