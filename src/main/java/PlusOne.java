import java.util.Stack;

/**
 * Created by Administrator on 2016/5/3.
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
        int[] digits = {8,9,9,9};
        int[] ans = plusOne(digits);
        for (int t : ans) {
            System.out.print(t);
        }
    }
    public static int[] plusOne(int[] digits) {
        if (digits == null) return null;
        if (digits.length == 0) return new int[0];
        int index = digits.length - 1;
        Stack<Integer> stack = new Stack<Integer>();
        int lastv = digits[digits.length - 1] + 1;
        int carry = (lastv)/10;
        stack.add(lastv%10);
        for (int i = digits.length - 2; i >= 0; i--) {
            lastv = digits[i] + carry;
            carry = (lastv)/10;
            stack.add(lastv%10);
        }
        stack.add(carry);
        if (stack.peek() == 0) {
            stack.pop();
        }
        int len = stack.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
