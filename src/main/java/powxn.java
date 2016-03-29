/**
 * Created by xk on 2016/3/29.
 */
public class powxn {
    /***
     * 递归，时间复杂度为O(n)
     * @param x
     * @param n
     * @return
     */
    public double myPowusingRec(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) return (1.0/myPowusingRec(x, -n));
        return x*myPowusingRec(x, n - 1);
    }

    /***
     * 算出half，这样的话，时间复杂度为O(lgn)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) return (1.0/myPow(x, -n));
        double half = myPow(x, n>>1);
        if (n % 2 == 0)
            return half*half;
        else
            return half*half*x;
    }
}
