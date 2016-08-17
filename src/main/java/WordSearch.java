import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/14.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.print(exist(board, "ABCCED"));
    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (word.length() == 1 || helpSearch(board, visited,i, j, word.substring(1))) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    public static boolean helpSearch(char[][] board, boolean[][] visited, int i, int j, String word) {
        if (word.length() == 0) return true;
        int[][] dir = {
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}};
        for (int k = 0; k < dir[0].length; k++) {
            int ii = i + dir[k][0];
            int jj = j + dir[k][1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length
                    && board[ii][jj] == word.charAt(0) && visited[ii][jj] == false) {
                visited[ii][jj] = true;
                if (word.length() == 1 || helpSearch(board, visited, ii, jj, word.substring(1))) {
                    return true;
                }
                visited[ii][jj] = false;
            }
        }
        return false;
    }
}
