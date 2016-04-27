/**
 * Created by Administrator on 2016/4/27.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] A = {3, 8, 4};
        System.out.print(houseRobber(A));
    }
    public static long houseRobber(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        long[] ans = new long[A.length];
        ans[0] = A[0];
        ans[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + A[i]);
        }
        return ans[A.length - 1];
    }
}
