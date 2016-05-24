/**
 * Created by Administrator on 2016/5/24.
 */
public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 15;
        System.out.print(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null ||  matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = matrix[0].length - 1;
        while (j >=0 && i < m) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
