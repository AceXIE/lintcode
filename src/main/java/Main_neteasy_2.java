import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Main_neteasy_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int n = in.nextInt(), m = in.nextInt();
        char[][] value = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                value[i][j] = s.charAt(j) ;
            }
        }
        int x0 = in.nextInt(), y0 = in.nextInt();
        int k = in.nextInt();
        int[][] d = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                d[i][j] = in.nextInt();
            }
        }

        for (int[] i : d)
            for (int j : i)
                System.out.print(j);
    }
}
