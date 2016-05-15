/**
 * Created by Administrator on 2016/5/15.
 */
public class checkPowerOf2 {
    public static void main(String[] args) {
        int n = 5;
        System.out.print(checkPowerOf2(n));
    }
    public static boolean checkPowerOf2(int n) {
        if (n == 0) return false;
        if (n == Integer.MIN_VALUE) return false;
        return (n & (n - 1)) == 0;
    }
}
