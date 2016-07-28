/**
 * Created by Administrator on 2016/7/28.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.print(divide(200,100));
    }
    //任何一个数均可以写成
    // num=a0*2^0+a1*2^1+a2*2^2+...+an*2^n
    public static int divide(int dividend, int divisor) {
        long res = helper((long)dividend, (long)divisor);
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
    public static long helper(long dividend, long divisor) {
        if (divisor == 1) return dividend;
        int sign = 1;
        if (dividend < 0 ^ divisor < 0) sign = -1;

        long tmp = Math.abs(dividend), tmp1 = Math.abs(divisor);
        long c = 1;
        while (tmp > tmp1) {
            tmp1 = tmp1<<1;
            c = c<<1;
        }
        long res = 0;
        while (tmp >= Math.abs(divisor)) {
            while (tmp >= tmp1) {
                tmp = tmp - tmp1;
                res += c;
            }
            tmp1 = tmp1>>1;
            c = c>>1;
        }
        return sign*res;
    }
}
