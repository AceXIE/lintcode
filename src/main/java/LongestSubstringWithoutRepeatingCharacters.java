import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/24.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "an++--viaj";
        System.out.print(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {//存在c
                len = Math.max(len, hashMap.size());
                i = hashMap.get(c);
                hashMap.clear();//清除了什么
            } else {
                hashMap.put(c, i);
            }
        }
        return Math.max(len, hashMap.size());
    }
}
