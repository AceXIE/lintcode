import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/7.
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.print(isHappy(n));
    }
    public static boolean isHappy(int n) {
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        int sum = 0;
        n = Sum(n);
        while (n != 1) {
            if (map.containsKey(n)) {
                return false;
            } else {
                map.put(n, true);
            }
            n = Sum(n);
        }
        return true;
    }
    public static int Sum(int n) {
        int ans = 0;
        while (n != 0) {
            int digital = n%10;
            ans += digital * digital;
            n = n/10;
        }
        return ans;
    }
}
