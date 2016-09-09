/**
 * Created by Administrator on 2016/9/5.
 */
public class Main_ZTE {
    public static void main(String[] args) {
        Main_ZTE a = new Main_ZTE();
//        System.out.print(a.Test2(28));

//        int[][] matrix = new int[][] {
//                {1,2,3},
//                {4,5,6}
//        };
//        int[][] res = a.vo(matrix, 0);
//        for (int[] b : res) {
//            for (int i : b) {
//                System.out.print(i + ",");
//            }
//            System.out.println();
//        }

        a.printRows(6);

    }

    public void printRows(int rows) {
        int[][] ans = new int[rows][rows + 1];
        int index = 1;
        int bTime = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows + 1; j++) {
                if (bTime == 0 && j < rows) {
                    ans[i][j] = index;
                } else if (bTime == 0 && j == rows) {
                    ans[i][j] = index + 1;
                    bTime = 1;
                    index = index + 2;
                } else if (bTime == 1 && j < 1) {
                    ans[i][j] = index;
                } else if (bTime == 1) {
                    ans[i][j] = index - 1;
                    if (j == rows){
                        bTime = 0;
                    }
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
    public int[][] vo(int[][] matrix, int flag) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        int c = n - 1, r = 0;
        if (flag == 0) {//左
            for (int i = 0; i < n; i++) {
                r = 0;
                for (int j = 0; j < m; j++) {
                    res[i][j] = matrix[r++][c];
                }
                c--;
            }
        } else {
            c = 0; r = m - 1;
            for (int i = 0; i < n; i++) {
                r = m - 1;
                for (int j = 0; j < m; j++) {
                    res[i][j] = matrix[r--][c];
                }
                c++;
            }
        }
        return res;
    }
    public int Test1(String[] arr) {
        if (arr == null) return -1;
        int N = arr.length;
        if (N == 0) return -1;

        String las = arr[0];
        for (int i = 1; i < N; i++) {
            String cur = arr[i];
            if (las.charAt(las.length() - 1) != cur.charAt(0)) {
                return -1;
            }
            las = cur;
        }
        return 1;
    }
    public int Test2(int n) {
        if (n == 1) return 1;
        int Ori = n;
        int sum = 1;
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                sum += i;
            }
        }
        if (sum == n) {
            return 1;
        }
        return 0;
    }
}
