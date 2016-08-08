import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xk on 2016/3/26.
 */
public class NQueens {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> res = solveNQueens(4);
        for (ArrayList<String> strings : res) {
            System.out.println(strings);
        }
    }
    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        int[] col = new int[n];
        DFSHelper(res, col, n, 0);
        return res;
    }
    public static void DFSHelper(ArrayList<ArrayList<String>> res, int[] col, int n, int row) {
        if (row == n) {
            ArrayList<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == col[i]) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                tmp.add(stringBuilder.toString());
            }
            res.add(tmp);
        } else {
            for (int i = 0; i < n; i++) {
                col[row] = i;
                if (isVal(col, row)) {
                    DFSHelper(res, col, n, row + 1);
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
