import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/12.
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.print(restoreIpAddresses(s));
    }
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return ans;
        ArrayList<String> tmp = new ArrayList<>();
        helper(ans, s, tmp, 0, 1);
        return ans;
    }
    public static void helper(ArrayList<String> ans, String s, ArrayList<String> tmp, int index, int kth) {
        if (index == s.length()) {
            if (kth == 5) {
                String string = tmp.get(0);
                for (int i = 1; i < 4; i++) {
                    string = string + "." + tmp.get(i);
                }
                ans.add(string);
            }
            return;
        }
        for (int i = 1; i < 4 && index + i - 1 < s.length(); i++) {
            String st = s.substring(index, index + i);
            if (isVal(st)) {
                tmp.add(st);
                helper(ans, s, tmp, index + i, kth +1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    public static boolean isVal(String num) {
        int len = num.length();
        if (len == 1 && num.compareTo("0") >= 0 && num.compareTo("9") <= 0) return true;
        if (len == 2 && num.compareTo("10") >= 0 && num.compareTo("99") <= 0) return true;
        if (len == 3 && num.compareTo("100") >= 0 && num.compareTo("255") <= 0) return true;
        return false;
    }
}
