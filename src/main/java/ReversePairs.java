/**
 * Created by Administrator on 2016/8/13.
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 5};
        System.out.print(reversePairs(A));
    }
    public static long reversePairs(int[] A) {
        if (null == A || A.length == 0) return 0;
        return mergeSort(A, 0, A.length - 1);
    }
    public static long mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start)/2;
        long sum = 0;
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid + 1, end);
        sum += merge(A, start, mid, end);
        return sum;
    }
    public static long merge(int[] A, int start, int mid, int end) {
        int[] tmp = new int[A.length];
        int lIndex = start;
        int rIndex = mid + 1;
        int index = start;
        long sum = 0;
        while (lIndex <= mid && rIndex <= end) {
            if (A[lIndex] <= A[rIndex]) {
                tmp[index++] = A[lIndex++];
            } else {
                tmp[index++] = A[rIndex++];
                sum += mid - lIndex + 1;
            }
        }
        while (lIndex <= mid) {
            tmp[index++] = A[lIndex++];
        }
        while (rIndex <= end) {
            tmp[index++] = A[rIndex++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = tmp[i];
        }
        return sum;
    }
    //暴力
    public static long reversePairsBao(int[] A) {
        if (null == A || A.length == 0) return 0;
        long res = 0;
        int len = A.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (A[i] > A[j]) res++;
            }
        }
        return res;
    }
}
