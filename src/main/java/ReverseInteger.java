/**
 * Created by Administrator on 2016/6/22.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int n = -123;
        System.out.print(reverseInteger(n));
    }
    public static int reverseInteger(int n) {
        if (n == 0) return 0;
        boolean isN = false;
        if (n < 0) {
            n = -n;
            isN = true;
        }
        long ans = 0;
        while (n != 0) {
            ans = ans*10 + n%10;
            if (ans > Integer.MAX_VALUE) return 0;
            n /= 10;
        }
        if (isN) ans = -ans;
        return (int) ans;
    }
}
