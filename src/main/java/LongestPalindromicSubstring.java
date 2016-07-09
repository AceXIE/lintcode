/**
 * Created by Administrator on 2016/7/9.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abcdzdcab";
        System.out.print(longestPalindrome(s));
    }
    //DP动态规划问题
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = "";
        int max = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <=2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (max<j -i +1) {
                        max = j -i + 1;
                        ans = s.substring(i, j+1);
                    }
                }
            }
        }
        return ans;
    }
}
