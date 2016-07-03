import jdk.nashorn.internal.runtime.arrays.ArrayData;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/3.
 */
public class SortIntegersII {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        sortIntegers2(A);
        for (int i : A) {
            System.out.print(i + ",");
        }
    }
    public static void sortIntegers2(int[] A) {
        if (A == null) return;
        sortIntegersQuick(A, 0, A.length - 1);
    }
    public static void sortIntegersQuick(int[] A, int low, int high) {
        int i, pivotkey, j;
        if (low < high) {
            pivotkey = A[low];i = low; j = high;
            while (i < j) {
                while (i < j && A[j] >= pivotkey) j--;
                if (i < j) A[i++] = A[j];
                while (i < j && A[i] <= pivotkey) i++;
                if (i < j) A[j--] = A[i];
            }
            A[i] = pivotkey;
            sortIntegersQuick(A, low, i - 1);
            sortIntegersQuick(A, i + 1, high);
        }
    }
    public static void sortIntegersMerge(int[] A) {
//        if ()
    }
    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r)/2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }
    public static void merge(int[] A, int p, int q, int r) {
//        int[] left = Arrays.copyOfRange(A, p, q + 1);
//        int[] right = Arrays.copyOfRange(A, q + 1, r + 1);
//
//        int i=0, j=0, k=0;
//        while (k < r - p + 1) {
//
//        }
    }
    public static void sortIntegersHeap(int[] A) {

    }

}
