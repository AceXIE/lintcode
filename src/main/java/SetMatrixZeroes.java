import java.util.Vector;

/**
 * Created by Administrator on 2016/4/28.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2},
                {0,3}};
        setZeroes(matrix);
        for (int[] a : matrix) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        if (rowLength == 0 || columnLength == 0) return;
        boolean rowFlag = false, columnFlag = false;
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                columnFlag = true;
                break;
            }
        }
        for (int i = 0; i < columnLength; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < columnLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < columnLength; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (rowFlag) {
            for (int i = 0; i < columnLength; i++) {
                matrix[0][i] = 0;
            }
        }
        if (columnFlag) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
