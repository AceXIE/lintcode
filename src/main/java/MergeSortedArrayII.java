/**
 * Created by Administrator on 2016/4/10.
 */
public class MergeSortedArrayII {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] B = {2, 4, 5, 6};
        mergeSortedArray(A, B);
    }
    public static int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null) return B;
        if (B == null) return A;
        int[] ans = new int[A.length + B.length];
        int indexA = 0, indexB = 0, index = 0;
        for (index = 0; index < A.length + B.length; ) {
            if (indexA < A.length && indexB < B.length) {
                if (A[indexA] <= B[indexB]) {
                    ans[index++] = A[indexA++];
                } else {
                    ans[index++] = B[indexB++];
                }
            } else {
                break;
            }
        }
        while (indexA < A.length) {
            ans[index++] = A[indexA++];
        }
        while (indexB < B.length) {
            ans[index++] = B[indexB++];
        }
        for(int t : ans) {
            System.out.print(t);
        }
        return ans;
    }
}
