import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/7.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.print(minWindow(source,target));
    }
    public static String minWindow(String source, String target) {
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            if (!tmap.containsKey(c)) {
                tmap.put(c, 1);
            } else {
                tmap.put(c, tmap.get(c) + 1);
            }
        }
        int begin = 0, end = 0;
        String minStr = "";
        int min = Integer.MAX_VALUE;
        int found = 0;
        Map<Character, Integer> fmap = new HashMap<>();
        while (end < source.length()) {
            Character c = source.charAt(end);
            if (tmap.containsKey(c)) {
                if (fmap.containsKey(c)) {
                    if (fmap.get(c) < tmap.get(c)) {
                        found++;
                    }
                    fmap.put(c, fmap.get(c) + 1);
                } else {
                    fmap.put(c, 1);
                    found++;
                }
            }
            if (found == target.length()) {
                Character sc = source.charAt(begin);
                while (!fmap.containsKey(sc) || fmap.get(sc) > tmap.get(sc)) {
                    if (fmap.containsKey(sc) && fmap.get(sc) > tmap.get(sc)) {
                        fmap.put(sc, fmap.get(sc) - 1);
                    }
                    begin++;
                    sc = source.charAt(begin);
                }
                if (end - begin + 1 < min) {
                    min = end - begin + 1;
                    minStr = source.substring(begin, end + 1);
                }
            }
            end++;
        }
        return minStr;
    }
}
