import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/11.
 */
public class MajorityNumberII {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 1, 2, 1, 3, 3};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            nums.add(a[i]);
        }
        System.out.print(majorityNumber2(nums));
    }
    /***
     * 采用Map进行计数，空间复杂度较高
     * @param nums
     * @return
     */
    public static int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return -1;
        Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
        int count = nums.size()/3;
        for (Integer t : nums) {
            int sum = 1;
            if (map.containsKey(t)) {
                sum = map.get(t) + 1;
            }
            map.put(t, sum);
            if (sum > count) {
                return t;
            }
        }
        return -1;
    }
    public static int majorityNumber2(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return -1;
        int n1 = 0, n2 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count1 == 0) {
                n1 = nums.get(i);
            }
            if (count2 == 0 && n1 != nums.get(i)) {
                n2 = nums.get(i);
            }
            if (n1 != nums.get(i) && n2 != nums.get(i)
                    && count1 != 0 && count2 != 0) {
                count1--;
                count2--;
            }
            if (n1 == nums.get(i)) {
                count1++;
            }
            if (n2 == nums.get(i)) {
                count2++;
            }
        }
        return (count1>count2?n1:n2);
    }
}
