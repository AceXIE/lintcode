import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/11.
 */
public class Main_NetEasy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[3];
        PointXY[] pointXies= new PointXY[n];

        for (int i = 0; i < n; i++) {
            pointXies[i] = new PointXY(1,1);
            pointXies[i].x = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pointXies[i].y = in.nextInt();
        }
        PointXY min = new PointXY(1001,1001);
        for (int i = 0; i < n; i++) {
            if (min.x + min.y > pointXies[i].x + pointXies[i].y) {
                min = pointXies[i];
            }
        }
        int ans = 0;
        ans = min.x - 1 + min.y - 1;
        System.out.println(ans);

    }
}
class PointXY {
    public int x, y;

    PointXY (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
