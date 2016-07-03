/**
 * Created by Administrator on 2016/7/3.
 */
public class SortIntegers {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        sortIntegersSelection(A);
        for (int i : A) {
            System.out.print(i + ",");
        }
    }
    public static void sortIntegersSelection(int[] A) {
        if (A == null) return;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int k = i;
            for (int j = i + 1; j < len; j++) {
                if (A[j] < A[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int tmp = A[k];
                A[k] = A[i];
                A[i] = tmp;
            }
        }
    }
    public static void sortIntegersInsertion(int[] A) {
        if (A == null) return;
        int len = A.length;
        for (int i = 1; i < len; i++) {
            int tmp = A[i];
            int j = 0;
            for (j = i; j > 0 && A[i - 1] > tmp; j--) {
                A[j] = A[j - 1];
            }
            A[j] = tmp;
        }
    }
    public static void sortIntegersBubble(int[] A) {
        if (A == null) return;
        int len = A.length;
        for (int i = len - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
