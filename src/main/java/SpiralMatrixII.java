/**
 * Created by Administrator on 2016/4/11.
 */
public class SpiralMatrixII {
    public static void main(String[] main) {
        int n = 3;
        int[][] ans = generateMatrix(n);
        for (int[] i: ans) {
            for (int j : i) {
                System.out.print(j);
                System.out.print(",");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0, count = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        while (true) {
            //上，左->右
            for (i = left; i <= right; i++) {
                ans[top][i] = count++;
            }
            if (++top > bottom) {
                break;
            }
            //右，上->下
            for (i = top; i <= bottom; i++) {
                ans[i][right] = count++;
            }
            if (--right < left) {
                break;
            }
            //下， 右->左
            for (i = right; i >= left; i--) {
                ans[bottom][i] = count++;
            }
            if (--bottom < top) {
                break;
            }
            //左， 下->上
            for (i = bottom; i >= top; i--) {
                ans[i][left] = count++;
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
