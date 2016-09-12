import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Main_NetEasy912_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt(), y = in.nextInt();

        System.out.print(Rev(Rev(x) + Rev(y)));

    }
    public static int Rev(int x) {
        StringBuffer s = new StringBuffer(String.valueOf(x));
        s = s.reverse();
        return Integer.valueOf(s.toString());
    }
}
