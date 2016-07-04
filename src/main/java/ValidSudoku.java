import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/4.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int NUM = 9;
        boolean[] rows = new boolean[NUM];
        boolean[]cols = new boolean[NUM];
        boolean[] blocks = new boolean[NUM];

        for (int i = 0; i < NUM; i++) {
            Arrays.fill(rows, false);
            Arrays.fill(cols, false);
            Arrays.fill(blocks, false);
            for (int j = 0; j < NUM; j++) {
                if (!check(rows, board[i][j] - '1') ||
                        !check(cols, board[j][i] - '1') ||
                        !check(blocks, board[3*(i/3) + j/3][3*(i%3) + j%3] - '1')) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean check(boolean[] num, int val) {
        if (val < 0) return true;
        if (num[val]) return false;
        num[val] = true;
        return true;
    }
}
