import java.util.Stack;

/**
 * Created by Administrator on 2016/7/29.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};//{"2", "1", "+", "3", "*"};
        System.out.print(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        if (len == 1) return Integer.parseInt(tokens[0]);
        int res = 0, n1 = 0, n2 = 0;
        for (int i = 0; i < len; i++) {
            Character c;
            if (tokens[i].length() == 1) {
                c = tokens[i].charAt(0);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }
            if (c.equals('+')) {
                res = stack.pop() + stack.pop();
                stack.push(res);
            } else if (c.equals('-')) {
                n1 = stack.pop();
                n2 = stack.pop();
                res = n2 - n1;
                stack.push(res);
            } else if (c.equals('*')) {
                res = stack.pop() * stack.pop();
                stack.push(res);
            } else if (c.equals('/')) {
                n1 = stack.pop();
                n2 = stack.pop();
                res = n2/n1;
                stack.push(res);
            } else {
                stack.push(c - '0');
            }
        }
        return res;
    }
}
