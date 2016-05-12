/**
 * Created by Administrator on 2016/5/12.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] A = {1,3,5,6};
        int target = 0;
        System.out.print(searchInsert(A,target));
    }
    public static int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        if (target < A[0]) return 0;
        if (target > A[A.length - 1]) return A.length;
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
