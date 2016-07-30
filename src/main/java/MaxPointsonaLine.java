import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MaxPointsonaLine {
    public static void main(String[] args) {
        Point[] points = new Point[4];
        points[0] = new Point(1,2);
        points[1] = new Point(3,6);
        points[2] = new Point(0,0);
        points[3] = new Point(1,3);
        System.out.print(maxPoints(points));
    }
    public static int maxPoints(Point[] points) {
        if (points == null) return 0;

        Map<Double, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int dup = 1;//记录重合点
            double slope = 0.0;
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {//自身
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {//重合
                    dup++;
                    continue;
                } else if (points[i].x == points[j].x) {
                    slope = Integer.MAX_VALUE;
                } else {
                    slope = ((double)(points[j].y - points[i].y))/(points[j].x - points[i].x);
                }
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 1);
                }
            }
            if (map.isEmpty()) {
                max = Math.max(max, dup);
            } else {
                for (double d : map.keySet()) {
                    max = Math.max(map.get(d) + dup, max);
                }
            }
        }
        return max;
    }
}
