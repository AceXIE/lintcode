import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/12.
 */
public class PermutationIndexII {
    public static void main(String[] args) {
        int[] A = {3,2,2,1,1};//{1,4,2,2};
        System.out.print(permutationIndexII(A));
    }
    public static long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();//记录重复次数
        int len = A.length;
        long ans = 0;
        long factor = 1;
        int dup = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (!map.containsKey(A[i])) {
                map.put(A[i],1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
                dup *= map.get(A[i]);
            }
            long num = 0;
            for (int j = i + 1; j < len; j++) {
                if (A[i] > A[j]) {
                    num++;
                }
            }
            ans += num*factor / dup;
            factor *= (len - i);
        }
        return ans + 1;
    }
}
