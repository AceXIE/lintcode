import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/12.
 */
public class CompareStrings {
    public static void main(String[] args) {
        String A = "ABCD";
        String B = "AACD";
        System.out.print(compareStrings(A, B));
    }
    public static boolean compareStrings(String A, String B) {
        if (A == null ^ B == null) return false;
        if (A == null && B == null) return true;
        if (A.length() < B.length()) return false;
        int[] nums = new int[26];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < A.length(); i++) {
            nums[A.charAt(i) - 'A'] ++;
        }
        for (int i = 0; i < B.length(); i++) {
            int index = B.charAt(i) - 'A';
            nums[index]--;
            if (nums[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
