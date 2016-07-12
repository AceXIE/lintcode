/**
 * Created by Administrator on 2016/7/12.
 */
public class NumberofIslands {
    public static void main(String[] args) {
        int[][] grid ={};
//      int[][] grid = {
//                {1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {0, 0, 0, 1, 1},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1}};
//        boolean[][] gr = new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                gr[i][j] = (grid[i][j] == 0)?false:true;
//            }
//        }
        System.out.print(numIslands(grid));
    }
    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[0].length) return;
        if (grid[x][y] != 1) return;//已经访问
        grid[x][y] = 2;
        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }
}
