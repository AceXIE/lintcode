import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/11.
 */
public class Main_NetEasy_Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (N < 4) System.out.println(0);
        int lastF = 0, curF = 1, now = 1;
        int ans = Integer.MAX_VALUE;
        while (now < N){
            now = curF + lastF;
            lastF = curF;
            curF = now;
            ans = Math.min(ans, Math.abs(N - now));
        }
        System.out.println(ans);
        if (now == N) {
            System.out.println(0);
        } else {
//            ans = Math.min(ans, curF + lastF);
            System.out.println(ans);
        }
    }
}
