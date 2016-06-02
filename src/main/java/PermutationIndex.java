/**
 * Created by Administrator on 2016/6/2.
 */
public class PermutationIndex {
    public static void main(String[] args) {
        int[] A = {1,2,4};
        System.out.print(permutationIndex(A));
    }

    /***
     * 算法
     * @param A
     * @return
     */
    public static long permutationIndex(int[] A) {
        if (A == null || A.length == 0) return 0;
        long ans = 0;
        long position = 2;
        long factor = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            long num = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    num++;
                }
            }
            ans += (num * factor);
            factor *= position;
            position++;
        }
        return ans+1;
    }

}
