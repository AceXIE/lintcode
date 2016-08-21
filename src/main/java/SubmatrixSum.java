import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/20.
 */
public class SubmatrixSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1 ,5 ,7},
                {3 ,7 ,-8},
                {4 ,-8 ,9}};
        int[][] ans = submatrixSum(matrix);
        for (int[] a : ans) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
    public static int[][] submatrixSum(int[][] matrix) {
        int[][] ans = new int[2][2];
        int row = matrix.length;
        if (row == 0) return ans;
        int col = matrix[0].length;
        if (col == 0) return ans;

        int[][] sums = new int[row + 1][col + 1];//[0,0]~[i,j]的数值和
        for (int i = 0; i <= row; i++) {
            sums[i][0] = 0;
        }
        for (int i = 0; i <= col; i++) {
            sums[0][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sums[i + 1][j + 1] = matrix[i][j] + sums[i + 1][j] + sums[i][j + 1] - sums[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j <= row; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = 0; k <= col; k++) {
                    int diff = sums[j][k] - sums[i][k];
                    if (map.containsKey(diff)) {
                        int m = map.get(diff);
                        ans[0][0] = i; ans[0][1] = m;
                        ans[1][0] = j - 1; ans[1][1] = k - 1;
                        return ans;
                    } else {
                        map.put(diff, k);
                    }
                }
            }
        }
        return ans;
    }
}
