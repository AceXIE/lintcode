import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2016/5/30.
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {-3,1,2,-3,4};
        ArrayList<Integer> ans = subarraySum(nums);
        for (Integer i : ans) {
            System.out.print(i);
        }
    }
    public static ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<Integer, Integer>();
        int sum = 0;
        hashMap.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum)) {
                arrayList.add(hashMap.get(sum) + 1);
                arrayList.add(i);
                return arrayList;
            } else { //不存在
                hashMap.put(sum, i);
            }
        }
        return arrayList;
    }
}
