import java.io.*;
import java.util.*;
/**
 * Created by xk on 2016/3/30.
 * 蘑菇街
 * 使用平台：http://oj.acmcoder.com/ExamNotice.html
 */
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while (cin.hasNext()) {
            int i = 0;
            boolean flag = false;
            a = cin.nextInt();
            b = cin.nextInt();
            for (i = a; i <= b; i++) {
                if (isShui(i)) {
                    if (!flag) {
                        System.out.print(i);
                    } else {
                        System.out.print(" ");
                        System.out.print(i);
                    }
                    flag = true;
                }
            }
            if (!flag){
                System.out.print("no\n");
            } else {
                System.out.println();
            }
        }
    }
    public static boolean isShui(int a) {
        int sum = 0;
        int origin = a;
        while (a > 0) {
            sum += (int)Math.pow(a%10, 3);
            a /= 10;
        }
        if (sum == origin) return true;
        else return false;
    }
}
