import java.util.ArrayList;

/**
 * Created by xk on 2016/3/26.
 */
public class NQueensII {
    public static void main(String[] args) {
        System.out.print(totalNQueens(4));
    }
    private static int res = 0;
    public static int totalNQueens(int n) {
        if (n <= 0) return 0;
        int[] col = new int[n];
        DFSHelper(col, n, 0);
        return res;
    }
    public static void DFSHelper(int[] col, int n, int row) {
        if (row == n) {
            res++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                col[row] = i;
                if (isVal(col, row)) {
                    DFSHelper(col, n, row + 1);
                }
            }
        }
    }
    public static boolean isVal(int[] col, int row) {
        for (int i = 0; i < row; i++) {
            if (col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
