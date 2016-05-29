import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> hh = combinationSum(candidates, target);
        for (List<Integer> ls : hh) {
            for (Integer i : ls) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static int[] candidates_copy = {};
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) return ans;
        Arrays.sort(candidates);
        candidates_copy = candidates;
        dfs(new ArrayList<Integer>(), target, 0);
        return ans;
    }

    /***
     * 回溯！！！！！！！！！！！
     * @param tmp
     * @param target
     * @param start
     */
    public static void dfs(List<Integer> tmp, int target, int start) {
        if (target == 0) {
            List<Integer> list = new ArrayList<Integer>(tmp);
            ans.add(list);
        } else {
            for (int i = start; i < candidates_copy.length && candidates_copy[i] <= target; i++) {
                tmp.add(candidates_copy[i]);
                dfs(tmp, target - candidates_copy[i], i);
                tmp.remove(new Integer(candidates_copy[i]));
            }
        }
    }
}
