import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Main_neteasy_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int minidx = -1, minidy = -1;
        int n = in.nextInt(), m = in.nextInt();
        int[][] value = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                value[i][j] = s.charAt(j) - '0';
                if (min > value[i][j]) {
                    min = value[i][j];
                    minidx = i;
                    minidy = j;
                }
            }
        }

        System.out.println(min);
    }
}
