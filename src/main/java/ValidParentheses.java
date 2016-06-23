import java.util.Stack;

/**
 * Created by Administrator on 2016/6/23.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "({)}";
        System.out.print(isValidParentheses(s));
    }
    public static boolean isValidParentheses(String s) {
        if (s == null || s.length() < 2) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char topChar = stack.pop();
                if ((c == '}' && topChar != '{')||(c ==']' && topChar!='[')||(c==')' && topChar!='(')) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
