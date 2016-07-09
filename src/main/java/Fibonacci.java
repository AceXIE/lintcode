/**
 * Created by Administrator on 2016/7/9.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.print(fibonacci(10));
    }
    public static int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int a = 0, b = 1;
        int ans = 1;
        while (n-- > 3) {
            a = b;
            b = ans;
            ans = a + b;
        }
        return ans;
    }
}
