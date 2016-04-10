import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/10.
 */
public class SingleNumberIII {
    public static void main(String[] args) {
//        int[] A = {1, 2, 2, 3, 4, 4, 5, 3};
        int[] A = {1,2,3,3,2,4,1,5};
        System.out.println(singleNumberIII(A));
    }

    /***
     * 异或之后，，如何将两者区分是个问题
     * or = a ^ b
     * a ^ or = b
     * b ^ or = a
     * @param A
     * @return
     */
    public static List<Integer> singleNumberIII(int[] A) {
        int or = 0;//or是两个不同的数异或的结果，将两者混在一起了
        for (int i = 0; i < A.length; i++) {
            or ^= A[i];
        }
        int r = or & (~(or - 1));//找到两者二进制之间第一个不同的
        List<Integer> ans = new LinkedList<Integer>();
        Integer res = new Integer(0);
        Integer res1 = new Integer(0);
        for (int i = 0; i < A.length; i++) {
            if ((r & A[i]) == 0) {
                res ^= A[i];
            } else {
                res1 ^= A[i];
            }
        }
        ans.add(res);
        ans.add(res1);
        return ans;
    }
}
