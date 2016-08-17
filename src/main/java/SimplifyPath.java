import java.util.Stack;

/**
 * Created by Administrator on 2016/8/17.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String s = "/abc/...";//"/home/";
        System.out.print(simplifyPath(s));
    }
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int len = path.length();
        for (int i = 0; i < len; i++) {
            while (i < len && '/' == path.charAt(i)) {
                i++;
            }
            String tmp = "";
            while (i < len && '/' != path.charAt(i)) {
                tmp = tmp + path.charAt(i);
                i++;
            }
            if (tmp.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!tmp.equals("") && !tmp.equals(".") && !tmp.equals("..")) {
                stack.push(tmp.toString());
            }
        }
        if (stack.isEmpty()) return "/";
        String ans = "";
        while (!stack.isEmpty()) {
//            ans.insert(0, "/");
//            ans.insert(0, stack.pop());
            ans = "/" + stack.pop() + ans;
        }
        return ans;
    }
}
