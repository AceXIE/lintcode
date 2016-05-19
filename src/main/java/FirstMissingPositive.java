import java.util.Arrays;

/**
 * Created by Administrator on 2016/5/19.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] A = new int[]{3,4,-1,1};
        System.out.print(firstMissingPositive(A));
    }
    public static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) return 1;
        for (int i = 0; i < A.length; i++) {
            while ( i + 1 != A[i]) {
                if (A[i] >= A.length || A[i] <= 0 || A[i] == A[A[i] - 1]) {
                    break;
                }
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i+1;
            }
        }
        return A.length+1;
    }
}
