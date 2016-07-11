import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Administrator on 2016/7/11.
 */
public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.print(intersection(nums1,nums2));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        for (int n1 : nums1) {
            if (map.containsKey(n1)) {
                map.put(n1, map.get(n1) + 1);
            } else {
                map.put(n1, 1);
            }
        }
        for (int n2 : nums2) {
            if (map.containsKey(n2)) {
                if (map.get(n2) > 0) {
                    vector.add(n2);
                    map.put(n2, map.get(n2) - 1);
                }
            }
        }
        int[] res = new int[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            res[i] = vector.get(i);
        }
        return res;
    }
}
