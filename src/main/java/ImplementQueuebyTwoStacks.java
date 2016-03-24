import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2016/3/21.
 */
public class ImplementQueuebyTwoStacks {

    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queueinit();
        push(scanner.nextInt());
        System.out.println(pop());
        push(scanner.nextInt());
        push(scanner.nextInt());
        System.out.println(top());
        System.out.println(pop());
    }
    public static void Queueinit() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    public static void push(int element) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(element);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    public static int pop() {
        return stack1.pop();
    }
    public static int top() {
        return stack1.peek();
    }

}
