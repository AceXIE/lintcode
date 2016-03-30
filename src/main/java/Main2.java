import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by xk on 2016/3/30.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        double n = 0;
        int m = 0;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            double res = n;
            for (int i = 1; i < m; i++) {
                res += Math.sqrt(n);
                n = Math.sqrt(n);
            }
            System.out.println(decimalFormat.format(res));
        }
    }
}
