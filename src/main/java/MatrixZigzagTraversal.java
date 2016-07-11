import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MatrixZigzagTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2,  3,  4},
                {5, 6,  7,  8},
                {9,10, 11, 12}};
        int[] matrix1 = printZMatrix(matrix);
        for (int m : matrix1) {
            System.out.print(m + ",");
        }
    }
    public static int[] printZMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return null;
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int COUNT = matrix.length * matrix[0].length;
        int i = 0, r = 0, c = 0;
        int[] ans = new int[COUNT];
        ans[0] = matrix[0][0];
        for (i = 1; i < COUNT; ) {
            //右上
            while (i < COUNT && r > 0 && c < matrix[0].length - 1) {
                ans[i++] = matrix[--r][++c];
            }
            //右一，如果不行，就下一步
            if (i < COUNT && c < matrix[0].length - 1) {
                ans[i++] = matrix[r][++c];
            } else if (i < COUNT && r < matrix.length - 1) {
                ans[i++] = matrix[++r][c];
            }
            //左下
            while (i < COUNT && r < matrix.length - 1 && c > 0) {
                ans[i++] = matrix[++r][--c];
            }
            //下一，如果不行，就右一
            if (i < COUNT && r < matrix.length - 1) {
                ans[i++] = matrix[++r][c];
            } else if (i < COUNT && c < matrix[0].length - 1) {
                ans[i++] = matrix[r][++c];
            }
        }
        return ans;
    }

}
