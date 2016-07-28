/**
 * Created by Administrator on 2016/7/28.
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.print(numDecodings("101010"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        int val;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i - 2) != '0') {
                val = Integer.parseInt(s.substring(i - 2, i));
                if (val > 0 && val <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

        }
        return dp[len];
    }
}
