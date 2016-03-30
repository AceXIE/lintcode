import java.io.*;
import java.util.*;
/**
 * Created by xk on 2016/3/30.
 * 蘑菇街
 */
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while (cin.hasNextInt()) {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }
    }
}
