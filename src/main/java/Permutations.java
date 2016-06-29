import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Permutations {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i < 4; i++) {
            nums.add(i);
        }
        ArrayList<ArrayList<Integer>> res  = permute(nums);
        for (ArrayList<Integer> a : res) {
            for (Integer i : a) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) return result;
        dfs(nums, 0, result);
        return result;
    }
    public static void dfs(ArrayList<Integer> a, int begin, ArrayList<ArrayList<Integer>> result) {
        int tmp = 0;
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        if (begin == a.size()) {
            for (int i = 0; i < a.size(); i++) {
                arraylist.add(a.get(i));
            }
            result.add(arraylist);
            return;
        } else {
            for (int i = begin; i < a.size(); i++) {
                tmp = a.get(i);
                a.set(i, a.get(begin));
                a.set(begin, tmp);
                dfs(a, begin + 1, result);
                tmp = a.get(i);
                a.set(i, a.get(begin));
                a.set(begin, tmp);
            }
        }
    }
}
