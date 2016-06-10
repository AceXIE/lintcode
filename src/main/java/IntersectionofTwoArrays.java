import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Administrator on 2016/6/10.
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {5,0,0,6,1,6,2,2,4};
        int[] res = intersection(nums1,nums2);
        for (int i : res) {
            System.out.print(i);
        }
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        int len1 = nums1.length, len2= nums2.length;
        if (len1 == 0 || len2 == 0) return new int[0];
        for (int i = 0; i < len1; i++) {

            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i],1);
            }
        }
        for (int i = 0; i < len2; i++) {
            int v2 = nums2[i];
            if (map.containsKey(v2)) {
                vector.add(v2);
                map.remove(v2);
            }
        }
        int[] res = new int[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            res[i] = vector.get(i);
        }
        return res;
    }
}
