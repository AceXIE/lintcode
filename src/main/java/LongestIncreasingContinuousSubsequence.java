/**
 * Created by Administrator on 2016/6/4.
 */
public class LongestIncreasingContinuousSubsequence {
    public static void main(String[] args) {
        int[] A = {5, 4, 2, 1, 3};
        System.out.print(longestIncreasingContinuous(A));
    }
    public static int longestIncreasingContinuous(int[] A) {
        if (A == null || A.length == 0) return 0;
        int res = 1;
        int start = 0;
        boolean fromLeft = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (fromLeft) {
                    res = Math.max(res, i - start + 1);
                } else {
                    start = i - 1;
                    fromLeft = true;
                }
            } else if (A[i] < A[i - 1]) {
                if (!fromLeft) {
                    res = Math.max(res, i - start + 1);
                } else {
                    fromLeft = false;
                    start = i - 1;
                }
            }
        }
        return res;
    }
}
