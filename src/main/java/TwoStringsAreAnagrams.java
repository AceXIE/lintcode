/**
 * Created by Administrator on 2016/5/15.
 */
public class TwoStringsAreAnagrams {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "dcaa";
        System.out.print(anagram(s,t));
    }
    public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]--;
            if (count[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
