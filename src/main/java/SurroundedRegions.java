import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/12.
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        surroundedRegions(board);
        for (char[] r : board) {
            System.out.println(r);
        }
    }
    public static void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0) return;
        if (board[0] == null || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i);
        }
        change(board, 'O', 'X');
        change(board, '#', 'O');
    }
    public static void dfs(char[][] board, int x, int y) {
        if (x<0 || x >= board.length) return;
        if (y < 0 || y >= board[0].length) return;
        if (board[x][y] == '#' || board[x][y] == 'X') return;
        board[x][y] = '#';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }
    public static void change(char[][] board, char ori, char tar) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ori) {
                    board[i][j] = tar;
                }
            }
        }
    }
}
