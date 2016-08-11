/**
 * Created by Administrator on 2016/8/11.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        String s = "aab";
        System.out.print(minCut(s));
    }
    public static int minCut(String s) {
        if (s == null) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];//dp[i][j]表示，从i到j是不是回文
        int[] cnt = new int[len + 1];//cnt[i]从i开始的字符串最小cut
        for (int i = len - 1; i >= 0; i--) {
            cnt[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1] == 1)) {
                    dp[i][j] = 1;
                    cnt[i] = Math.min(cnt[i], cnt[j + 1] + 1);
                }
            }
        }
        return cnt[0] - 1;
    }
}
