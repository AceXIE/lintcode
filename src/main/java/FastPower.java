/**
 * Created by Administrator on 2016/7/29.
 */
public class FastPower {
    public static void main(String[] args) {
        int a = 109, b = 10000007, n = 1000001;
        System.out.print(fastPower(a, b, n));
    }
    public static int fastPower(int a, int b, int n) {
        return (int)helper(a,b,n);
    }
    public static long helper(int a, int b, int n) {
        if (n == 1) return a%b;
        if (n == 0) return 1%b;
        long mid = fastPower(a, b, n/2);
        if (n%2 == 1) {//奇数
            return ((a%b)*mid%b) * mid%b;
        }
        return mid*mid%b;
    }
}
