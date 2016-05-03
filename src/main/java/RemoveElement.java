/**
 * Created by Administrator on 2016/5/3.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] A = {0,4,4,0,0,2,4,4};
        int elem = 4;
        System.out.print(removeElement(A,elem));
    }
    public static int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
//        if (A.length == 1)
        int pa = 0, pb = A.length - 1;
        while (pa <= pb) {
            if (A[pa] == elem) {
                A[pa] = A[pb--];
            } else {
                pa++;
            }
        }
        return pa;
    }
}
