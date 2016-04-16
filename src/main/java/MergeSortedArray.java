/**
 * Created by Administrator on 2016/4/16.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 1; A[1] = 2; A[2] = 3;
        int[] B = {4, 5};
        int m = 3, n = 2;
        mergeSortedArray(A, m, B, n);
        for(int t : A) {
            System.out.print(t);
        }
    }
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1, pres = m + n - 1;
        while (pa >= 0 && pb >= 0 ) {
            if (A[pa] > B[pb]) {
                A[pres--] = A[pa--];
            } else {
                A[pres--] = B[pb--];
            }
        }
        while (pb >= 0) {
            A[pres--] = B[pb--];
        }
    }
}
