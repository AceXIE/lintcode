/**
 * Created by Administrator on 2016/4/17.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 44;
        System.out.print(climbStairs(n));
    }

    /**
     * 斐波那契数列啊
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 0) return 1;
        int ans = 0;
        int pre = 0, cur = 1;
        for (int i = 0; i < n; i++) {
            ans = pre + cur;
            pre = cur;
            cur = ans;
        }
        return ans;
    }
    /***
     * 指数上涨，超时
     * @param n
     * @return
     */
    public static int climbStairsUsingRec(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
