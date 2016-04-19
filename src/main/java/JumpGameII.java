import java.util.*;

/**
 * Created by Administrator on 2016/4/12.
 */
public class JumpGameII {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};

        System.out.print(jump(A));
    }
    public static int jump(int[] A) {
        if (A == null || A.length == 0) return 0;
        int ret = 0;
        int curMax = 0; // 从0到i，这i+1个A元素所能达到的最大值
        int curRch = 0;//从A[0]进行ret次跳跃，所能达到的最远只
        for (int i = 0; i < A.length; i++) {
            if (curRch < i) {//说明，经过ret次跳跃，到不了。
                ret++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, i + A[i]);
        }
        return ret;
    }
}
