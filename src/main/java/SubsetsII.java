import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Administrator on 2016/8/24.
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        ArrayList<Integer> S = new ArrayList<>();
        for (int i : nums) {
            S.add(i);
        }
        SubsetsII s = new SubsetsII();
        ArrayList<ArrayList<Integer>> ans = s.subsetsWithDup(S);
        for (ArrayList<Integer> a : ans) {
            System.out.println(a);
        }
    }


    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        if (S == null) return ans;
        Collections.sort(S);
        helper(ans, tmp, S, 0);
        return ans;
    }
    public void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tmp, ArrayList<Integer> S, int start) {

//        if (!ans.contains(tmp)) {
            ans.add(new ArrayList<>(tmp));
//        }
        for (int i = start; i < S.size(); i++) {
            if (i != start && S.get(i) == S.get(i - 1)) continue;
            tmp.add(S.get(i));
            helper(ans, tmp, S, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
