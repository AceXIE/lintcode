import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/1.
 */
public class UniquePaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(uniquePaths(scanner.nextInt(), scanner.nextInt()));
    }

    /***
     * DP问题
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++) res[0][i] = 1;
        for (j = 0; j < m; j++) res[j][0] = 1;
        for (i = 1; i < n; i++) {
            for (j = 1; j < m; j++) {
                res[j][i] = res[j - 1][i] + res[j][i - 1];
            }
        }
        return res[m - 1][n - 1];
    }
    /***
     * 递归，时间不够用
     * @param m
     * @param n
     * @return
     */
    public static int uniquePathsRec(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePathsRec(m - 1, n) + uniquePathsRec(m, n - 1);
    }
}
