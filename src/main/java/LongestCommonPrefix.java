/**
 * Created by Administrator on 2016/5/25.
 * 最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"ABCDEFG", "ABCEFG" , "ABCEFA"};
        System.out.print(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        String ans = strs[0];
        int j = 0;
        for (int i = 1; i < strs.length; i++) {
            int len = Math.min(ans.length(), strs[i].length());
            for (j = 0; j < len; j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = strs[i].substring(0,j);
        }
        return ans;
    }
}
