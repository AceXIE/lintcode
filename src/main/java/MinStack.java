import java.util.Stack;

/**
 * Created by Administrator on 2016/5/1.
 */
public class MinStack {
    static Stack<Integer> stack = new Stack<Integer>();
    static Stack<Integer> minstack = new Stack<Integer>();
    public MinStack() {

    }
    public static void push(int number) {
        if (minstack.isEmpty() || number <= minstack.peek()) {
            minstack.push(number);
        }
        stack.push(number);
    }
    public static int pop() {
        int a = minstack.peek();
        int b = stack.peek();

        if (a == b) {
            minstack.pop();
        }
        int le = stack.peek();
        stack.pop();
        return le;
    }
    public static int min() {
        return minstack.peek();
    }
    public static void main(String[] args) {
        push(152);
        System.out.print(pop());
        push(163);
        System.out.print(min());
        System.out.print(pop());
        push(-3);push(3);push(2);
        System.out.print(pop());System.out.print(pop());System.out.print(pop());System.out.print(pop());
        push(400);push(3);push(200);push(1);
        System.out.print(min());
        System.out.print(pop());
        System.out.print(min());
    }
}
