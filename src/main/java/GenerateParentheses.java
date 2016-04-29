import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/29.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> arrayList = generateParenthesis(n);
        for (String s : arrayList) {
            System.out.print(s + ",");
        }
    }
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) return ans;
        String s = new String();
        helper(n, n, s, ans);
        return ans;
    }

    /***
     * r为右括号个数，l为左括号个数
     * @param l
     * @param r
     * @param s
     * @param res
     */
    public static void helper(int l, int r, String s, ArrayList<String> res) {
        if (r < l) return;
        if (l == 0 && r == 0) {
            res.add(s);
        }
        if (l > 0) helper(l - 1, r, s + "(", res);
        if (r > 0) helper(l, r - 1, s + ")", res);
    }
}
