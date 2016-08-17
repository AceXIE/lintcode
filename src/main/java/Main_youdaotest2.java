import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/16.
 */
public class Main_youdaotest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            double nn = n;
            if (n == 0) {
                System.out.print(0);
                return;
            }
            int m = in.nextInt();
            double sum = 0;
            for (int i = 0; i < m; i++) {
                sum += nn;
                nn = Math.sqrt(nn);
            }
            System.out.print(new DecimalFormat("#.##").format(sum));
        }
    }
}
