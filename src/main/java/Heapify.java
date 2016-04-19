/**
 * Created by Administrator on 2016/4/19.
 */
public class Heapify {
    public static void main(String[] args) {
        int[] A = {3,2,1,4,5};
        heapify(A);
        for (int t : A) {
            System.out.print(t);
        }
    }
    public static void heapify(int[] A) {
        int n = A.length;
        for (int i = n / 2; i >= 0; i--) {
            helper(A, i);
        }
    }
    public static void helper(int[] A, int i) {
        while (i < A.length) {
            int smallest = i;
            if (i * 2 + 1 < A.length && A[i * 2 + 1] < A[smallest]) {
                smallest = i * 2 + 1;
            }
            if (i * 2 + 2 < A.length && A[i * 2 + 2] < A[smallest]) {
                smallest = i * 2 + 2;
            }
            if (smallest == i) {
                break;
            }
            int tmp = A[smallest];
            A[smallest] = A[i];
            A[i] = tmp;

            i = smallest;
        }
    }
}
