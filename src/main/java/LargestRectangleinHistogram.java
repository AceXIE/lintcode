import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Administrator on 2016/7/4.
 */
public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        System.out.print(largestRectangleArea(height));
    }
    //
    public static int largestRectangleArea(int[] heightCopy) {
        if (heightCopy == null || heightCopy.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> height = new ArrayList<Integer>();
        for (int i : heightCopy) {
            height.add(i);
        }
        height.add(0);

        int MAX = 0;

        int leftarea = 0, rightarea = 0;
        for (int i = 0; i < height.size(); ++i) {
            while (!stack.isEmpty() && height.get(stack.peek()) > height.get(i)) {
                int tmp = stack.pop();
                leftarea = (stack.isEmpty() ? tmp + 1 : tmp - stack.peek())*height.get(tmp);
                rightarea = (i - tmp - 1) * height.get(tmp);
                if (MAX < (leftarea + rightarea)) MAX = leftarea + rightarea;
            }
            stack.push(i);
        }
        return MAX;
    }
}
