import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/8/20.
 */
public class WordBreak {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("lint");
        dict.add("code");
        String s = "lintcode";

        System.out.print(wordBreak(s, dict));
    }
    public static boolean wordBreak(String s, Set<String> dict) {
        if (dict == null) return false;
        if (s == null) return false;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (dp[i] == true) {
                for (int j = i + 1; j <= len; j++) {
                    if (dict.contains(s.substring(i,j))) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[len];
    }
}
