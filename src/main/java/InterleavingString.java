/**
 * Created by Administrator on 2016/6/10.
 */
public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.print(isInterleave(s1, s2, s3));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        String minStr = (s1.length() > s2.length()?s2:s1);
        String maxStr = (s1.length() > s2.length()?s1:s2);
        boolean[] dp = new boolean[minStr.length() + 1];
        dp[0] = true;
        for (int i = 0; i < minStr.length(); i++) {
            dp[i + 1] = dp[i] && (minStr.charAt(i) == s3.charAt(i));
        }
        for (int i = 0; i < maxStr.length(); i++) {
            dp[0] = dp[0] && (maxStr.charAt(i) == s3.charAt(i));
            for (int j = 0; j < minStr.length(); j++) {
                dp[j + 1] = dp[j + 1] && (maxStr.charAt(i) == s3.charAt(i + j + 1)) || dp[j] && (minStr.charAt(j) == s3.charAt(i + j + 1));
            }
        }
        return dp[minStr.length()];
    }
}
