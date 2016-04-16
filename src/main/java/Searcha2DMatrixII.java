/**
 * Created by Administrator on 2016/4/16.
 */
public class Searcha2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {
//                {1, 3, 5, 7},
//                {2, 4, 7, 8},
//                {3, 5, 9, 10}
        };
        int target = 3;
        System.out.print(searchMatrix(matrix, target));
    }
    public static int searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = 0;
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return 0;
        int cnt = 0;
        while (m >= 0 && n < matrix[0].length) {
            int cur = matrix[m][n];
            if (cur == target) {
                cnt++;
                m--;
                n++;
            } else if (cur > target) {
                m--;
            } else {
                n++;
            }
        }
        return cnt;
    }
}
