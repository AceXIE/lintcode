/**
 * Created by Administrator on 2016/4/12.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        rotate(matrix);
//        System.out.println(rotate(matrix));
        for (int[] a : matrix) {
            for (int b : a) {
                System.out.print(b + ",");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
