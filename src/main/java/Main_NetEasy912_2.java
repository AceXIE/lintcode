import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Main_NetEasy912_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 1) System.out.println(3);
            else if (n == 2) System.out.println(9);
            else if (n == 3) System.out.println(21);
            else {
                int ans = 0;
                int l1 = 3, l2 = 9;
                for (int i = 2; i < n; i++) {
                    ans = 2*l2 + l1;
                    l1 = l2;
                    l2 = ans;
                }
                System.out.println(ans);
            }
        }

    }
}
