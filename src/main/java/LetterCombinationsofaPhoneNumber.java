import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/6.
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        System.out.print(letterCombination("23"));
    }
    static ArrayList<String> ans;
    public static ArrayList<String> letterCombination(String digits) {
        String[] map = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder tmp = new StringBuilder();
        ans = new ArrayList<>();
        helper(map, 0, tmp, digits);
        return ans;
    }
    public static void helper(String[] map, int idx, StringBuilder tmp, String digits) {
        if (idx == digits.length()) {
            if (tmp.length() != 0) {
                ans.add(tmp.toString());
            }
        } else {
            String s = map[digits.charAt(idx) - '0'];
            for (int i = 0; i < s.length(); i++) {
                tmp.append(s.charAt(i));
                helper(map, idx + 1, tmp, digits);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
}
