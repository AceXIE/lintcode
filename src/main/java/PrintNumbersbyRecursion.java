import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class PrintNumbersbyRecursion {
    public static void main(String[] args) {
        System.out.print(numbersByRecusion(2));
    }
    public static List<Integer> numbersByRecusion(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        } else if (n == 1) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                ans.add(i);
            }
            return ans;
        } else {
            List<Integer> tmp = numbersByRecusion(n - 1);
            List<Integer> ans = new ArrayList<>(tmp);
            for (int i = 1; i < 10; i++) {
                int t = (int)Math.pow(10, n -1)*i;
                ans.add(t);
                for (int j = 0; j < tmp.size(); j++) {
                    ans.add(tmp.get(j) + t);
                }
            }
            return ans;
        }
    }
}
