import java.util.*;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Main_3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String string = cin.nextLine();
        String[] numS = string.split(",");
        int[] num = new int[numS.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(numS[i]);
        }
        Arrays.sort(num);
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Integer> stack = new Stack<Integer>();
        int last = -2, cur = -2, next = -2;
        int start = -2, end = -2;
        boolean bb = false;
        last = num[0];
        stack.add(last);
        int hold = num[0];
        for (int i = 1; i < num.length; i++) {
            cur = num[i];
            if (cur == hold || cur == hold + 1) {
                hold = cur;
            } else {
                stack.add(hold);
                hold = cur;
            }
        }
        stack.add(hold);
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i));
            System.out.print(i == stack.size() - 1?"\n":" ");
        }
    }
}
