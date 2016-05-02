import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/2.
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4, k =2;
        List<List<Integer>> lists = combine(n, k);
        for (List<Integer> list : lists) {
            for (Integer t : list) {
                System.out.print(t);
            }
            System.out.println();
        }
    }
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, 1, n ,k);
        return ans;
    }
    public static void helper(List<Integer> list, int begin, int n, int k) {
        if (list.size() == k) {
            List<Integer> tmp = new ArrayList<Integer>(list);
            ans.add(tmp);
            return;
        }
        for (int i = begin; i <= n; i++) {
            list.add(i);
            helper(list, i + 1, n, k);
            list.remove(new Integer(i));
        }
    }
}
