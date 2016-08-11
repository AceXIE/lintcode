
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/2.
 * 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，
 * 牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，和一般的游戏所不同的是，
 * 他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。
 * 地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
 */
public class Main_neteasy_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int n = in.nextInt(), m = in.nextInt();
        char[][] value = new char[n][m];
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                value[i][j] = s.charAt(j) ;
                if (value[i][j] == '.') {
                    matrix[i][j] = Integer.MAX_VALUE;
                } else {
                    matrix[i][j] = -2;
                }
            }
        }
        int x0 = in.nextInt(), y0 = in.nextInt();
        int k = in.nextInt();
        int[][] d = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                d[i][j] = in.nextInt();
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        matrix[x0][y0] = 0;
        queue.add(x0);
        queue.add(y0);
        while (!queue.isEmpty()) {
            int x = queue.pop();
            int y = queue.pop();
            int cnt = matrix[x][y];
            for (int i = 0; i < d.length; i++) {
                x+=d[i][0];
                y+=d[i][1];
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                        && matrix[x][y] == Integer.MAX_VALUE) {
                    matrix[x][y] = cnt + 1;
                    queue.add(x);
                    queue.add(y);
                }
                x -= d[i][0];
                y -= d[i][1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];;
                }
            }
        }
        if (max == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }
}
