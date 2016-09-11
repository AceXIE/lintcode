import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/11.
 */
public class Main_NetEasy2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println("both");
            return;
        }
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.next();
        }
        boolean gr = testGraphically(strings), le = testLegth(strings);
        if (gr && le) {
            System.out.println("both");
        } else if (gr) {
            System.out.println("lexicographically");
        } else if (le) {
            System.out.println("lengths");
        } else {
            System.out.println("none");
        }
    }
    public static boolean testGraphically(String[] strings) {
        int len = strings.length;
        String last = strings[0];
        for (int i = 1; i < len; i++) {
            String cur = strings[i];
            if (last.compareTo(cur) > 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean testLegth(String[] strings) {
        int len = strings.length;
        int last = strings[0].length();
        for (int i = 1; i < len; i++) {
            int cur = strings[i].length();
            if (last > cur) {
                return false;
            }
            last = cur;
        }
        return true;
    }
}
