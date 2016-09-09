import java.util.*;

/**
 * Created by Administrator on 2016/9/5.
 */
public class Main_JD {

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        int[] num = new int[10000];
        Arrays.fill(num, 1);
        for (int j = 2; j <= 10000; j++) {
            if (f(j) == g(j)) {
                num[j] = num[j - 1] + 1;
            } else {
                num[j] = num[j - 1];
            }
        }
        for (int i = 0; i < T; i++) {
            int a = cin.nextInt();
            System.out.println(num[a]);
        }
    }
//    public static void main(String args[])
//    {
//        System.out.println(f(123));
//        System.out.println(g(123));
//
//    }
    public static int f(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n/=10;
        }
        return sum;
    }
    public static int g(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n & 1);
            n = n >> 1;
        }
        return sum;
    }
}
