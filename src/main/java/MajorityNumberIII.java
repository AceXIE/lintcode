import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/12.
 */
public class MajorityNumberIII {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{3,1,2,3,2,3,3,4,4,4};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (Integer integer : integers) {
            nums.add(integer);
        }
        int k = 3;
        System.out.print(majorityNumber(nums,k));
    }
    public static int majorityNumber(ArrayList<Integer> nums, int k) {
        int len = nums.size();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer integer : nums) {
            if (map.containsKey(integer)) {
                int times = map.get(integer);
                times++;
                map.put(integer,times);
                if (times*k > len) return integer;
            } else {
                map.put(integer, 1);
            }
        }
        return 0;
    }
}
