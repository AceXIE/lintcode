/**
 * Created by Administrator on 2016/5/16.
 */
public class CosineSimilarity {
    public static void main(String[] args) {
        int[] A = {0};
        int[] B = {0};
        System.out.print(cosineSimilarity(A,B));
    }
    public static double cosineSimilarity(int[] A, int[] B) {
        if (A == null || B == null) return 0.0;
        if (A.length != B.length) return 0.0;
        if (A.length == 0 || (A.length == 1 && A[0]==0 && B[0]==0)) return 2.0;
        double a = 0, b = 0, c = 0;
        for (int i = 0; i < A.length; i++) {
            a+=A[i]*B[i];
            b+=A[i]*A[i];
            c+=B[i]*B[i];
        }
        if (b == 0 || c == 0) return 2.0;
        return a/(Math.sqrt(b)*Math.sqrt(c));
    }
}
