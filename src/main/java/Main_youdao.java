import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/16.
 */
public class Main_youdao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean has = false, isFirst = false;
        int m = in.nextInt(), n = in.nextInt();
        for (int i = m; i <= n; i++) {
            int sum = 0, or = i;
            while (i > 0) {
                sum += Math.pow(i%10,3);
                i = i/10;
            }
            i = or;
            if (sum == or) {
                if (has == false) {
                    System.out.print(or);
                    has = true;
                } else
                    System.out.print(" " + or);
            }
        }
        if (has == false) {
            System.out.println("no");
        }
    }
}
