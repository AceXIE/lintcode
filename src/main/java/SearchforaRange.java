import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by Administrator on 2016/8/13.
 */
public class SearchforaRange {
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int[] a = searchRange(A, 8);
        System.out.print(a[0] + "," + a[1]);
    }
    public static int[] searchRange(int[] A, int target) {
        int[] ans = {-1,-1};
        if (A == null || A.length == 0) return ans;
        int len = A.length;
        if (A[len - 1] < target || A[0] > target) return ans;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;

            if (A[mid] < target) {
                left = mid + 1;
            } else if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
                right = mid;
                while (left >= 0 && A[left] == target) {
                    left--;
                }
                ans[0] = left + 1;
                while (right < len && A[right] == target) {
                    right++;
                }
                ans[1] = right - 1;
                return ans;
            }
        }
        return ans;
    }
}
