import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {1,2},
//                {4,5},
//                {7,8}
        };
        List<Integer> ans = spiralOrder(matrix);
        for (Integer t : ans) {
            System.out.print(t);
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0) return ans;
        if (matrix[0] == null) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int i = 0;
        while (true) {
            for (int j = left; j <= right ; j++) {
                ans.add(matrix[top][j]);
            }
            if (++top > bottom) break;
            for (int j = top; j <= bottom ; j++) {
                ans.add(matrix[j][right]);
            }
            if (--right < left) break;
            for (int j = right; j >= left; j--) {
                ans.add(matrix[bottom][j]);
            }
            if (--bottom < top) break;
            for (int j = bottom; j >= top ; j--) {
                ans.add(matrix[j][left]);
            }
            if (++left > right) break;
        }
        return ans;
    }
}
