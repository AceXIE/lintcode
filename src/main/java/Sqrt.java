/**
 * Created by Administrator on 2016/7/13.
 */
public class Sqrt {
    public static void main(String[] args) {
        int x = 10;
        System.out.print(sqrt(x));
    }
    public static int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (mid > x/mid ) {
                right = mid - 1;
            } else if (mid < x/mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
