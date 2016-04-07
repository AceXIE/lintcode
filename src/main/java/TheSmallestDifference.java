import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/7.
 */
public class TheSmallestDifference {
    public static void main(String[] args) {
//        int[] a = {3, 6, 7, 4};
//        int[] b = {2, 8, 9, 3};
        int[] a = {3};
        int[] b = {10, 8, 16, 19, 6};
        System.out.println(smallestDifferent(a, b));
    }
    public static int smallestDifferent(int[] A, int[] B) {
        if (A.length == 1 && B.length == 1) return Math.abs(A[0] - B[0]);
        int ans = Integer.MAX_VALUE;
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            ans = Math.min(ans, binarySearch(B, A[i]));
        }
        return ans;
    }
    public static int binarySearch(int[] A, int num) {
        int l = 0, r = A.length - 1;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l)/2;
            res = Math.min(res, Math.abs(A[mid] - num));
            if (A[mid] == num) {
                return 0;
            } else if (A[mid] < num) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return res;
    }

}
