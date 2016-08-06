import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2016/8/6.
 */
public class KthSmallestNumberinSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1 ,5 ,7},
                {3 ,7 ,8},
                {4 ,8 ,9}};
        System.out.print(kthSmallest(matrix,4));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        if (k > matrix.length * matrix[0].length) return 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>(k);

        for (int i = 0; i < Math.min(matrix.length, k); i++) {
            queue.add(new Cell(i, 0, matrix[i][0]));
        }

        while (k > 1) {
            Cell p = queue.remove();
            if (p.y + 1 < matrix[p.x].length) {
                queue.add(new Cell(p.x, p.y + 1, matrix[p.x][p.y + 1]));
            }
            k--;
        }
        return queue.peek().value;
    }
}
class Cell implements Comparable<Cell> {
    final int x, y, value;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Cell o) {
        return this.value - o.value;
    }
}
