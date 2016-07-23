import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/23.
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] A = {1, -1};
        System.out.print(continuousSubarraySum(A));
    }
    public static ArrayList<Integer> continuousSubarraySum(int[] A) {
        if (A == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();
        if (A.length == 0) return ans;
        int left = 0, aleft = 0, aright = 0;
        int curSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            if (curSum >= max) {
                aleft = left;
                max = curSum;
                aright =i;
            }
            if (curSum < 0){
                if (i + 1 < A.length) {
                    left = i + 1;
                    curSum = 0;
                }
            }
        }
        ans.add(aleft);
        ans.add(aright);
        return ans;
    }
}
