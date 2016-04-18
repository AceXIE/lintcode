import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2016/4/16.
 */
public class kSumII {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int k = 2, target = 5;
        ArrayList<ArrayList<Integer>> arrayLists = kSumII(A, k, target);
        for (ArrayList<Integer> a : arrayLists) {
            for (Integer b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A.length < k || k <= 0) return ans;
        for (int i = 0; i < A.length; i++) {
            if (k == 1) {
                if (A[i] == target) {
                    ArrayList<Integer> cur = new ArrayList<Integer>();
                    cur.add(A[i]);
                    ans.add(cur);
                    return ans;
                }
            } else {
                int[] B = new int[A.length - i - 1];
                System.arraycopy(A, i + 1, B, 0, A.length - i - 1);
                ArrayList<ArrayList<Integer>> sub = kSumII(B, k - 1, target - A[i]);
                for (ArrayList<Integer> l : sub) {
                    l.add(0, A[i]);
                    ans.add(l);
                }
            }
        }
        return ans;
//        helper(A, 0, k, 0, target, cur, ans);
//        return ans;
    }
    public static void helper(int[] A, int index, int k, int sum, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
        if (cur.size() == k && sum == target) {
            res.add(cur);
            return;
        }
        if (sum > target || index == A.length) {
            return;
        }
        cur.add(A[index]);
        helper(A, index + 1, k, sum + A[index], target, cur, res);
        cur.remove(cur.size() - 1);
        helper(A, index + 1, k, sum, target, cur, res);
    }
    /***
     * 转化为2Sum问题
     * @param A
     * @param k
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> kSum2II(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<Integer, Integer>();
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        while (l < r) {
            if (A[l] + A[r] == target) {
                ArrayList<Integer> tans = new ArrayList<Integer>();
                tans.add(A[l]);
                tans.add(A[r]);
                ans.add(tans);
                l++;
                r--;
            } else if (A[l] + A[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
