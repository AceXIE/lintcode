import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "cdd";//"aab";
        List<List<String>> res = partition(s);
        for (int i = 0; i < res.size(); i++) {
            List<String> list = res.get(i);
            System.out.print(list);
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        List<String> path = new LinkedList<>();
        dfs(s, path, res);
        return res;
    }
    public static void dfs(String s, List<String> path, List<List<String>> res) {
        if (s.length() < 1) {
            LinkedList<String> t = new LinkedList<>(path);
            res.add(t);
            return;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int begin = 0;
            int end = i;
            while (begin <  end) {
                if (s.charAt(begin) == s.charAt(end)) {
                    begin++;
                    end--;
                } else {
                    break;
                }
            }
            if (begin >= end) {//是回文
                path.add(s.substring(0, i + 1));
                dfs(s.substring(i+1), path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
