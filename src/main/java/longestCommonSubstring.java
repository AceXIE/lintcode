/**
 * Created by Administrator on 2016/5/7.
 * The characters in substring should occur continuously in original string. This is different with subsequence.
 */
public class longestCommonSubstring {
    public static void main(String[] args) {
        String A="ABCD", B = "CBCE";
        System.out.print(longestCommonSubstring(A,B));
    }
    public static int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) return 0;
        int lenA = A.length(), lenB = B.length();
        int[][] dp = new int[lenA + 1][lenB + 1];
        int longest = 0;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                longest = Math.max(longest, dp[i][j]);
            }
        }
        return longest;
    }
}
