import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xk on 2016/3/31.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N; i++) {
            int nn = scanner.nextInt();
            int[] a = new int[nn];
            int[] ori = new int[nn];
            for (int j = 0; j < nn; j++) {
                a[j] = scanner.nextInt();
                ori[j] = a[j];
            }
            for (int ce = 0; ce < nn; ce++) {
                System.out.print(a[ce]);
            }
            System.out.println();
            Arrays.sort(a);
            for (int ce = 0; ce < nn; ce++) {
                System.out.print(a[ce]);
            }
            System.out.println();
            int res = 0;
            for (int ic = 0; ic < nn; ic++) {
                int bic = ic;
                while (a[ic] != ori[bic]) {
                    int copy = ori[ic];
                    ori[ic] = ori[bic];
                    ori[bic] = copy;
                    bic++;
                    res++;
                }
            }
            System.out.println(res);
        }
    }

}
