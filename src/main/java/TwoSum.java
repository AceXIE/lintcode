import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/24.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(numbers, target);
        for (int t : res) {
            System.out.print(t);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int i1 = numbers[i];
            if (map.containsKey(target - i1)) {
                ans[0] = i + 1;
                ans[1] = map.get(target - i1);
                return ans;
            }
        }
        return ans;
    }
}
