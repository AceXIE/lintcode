import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/29.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(longestCommonSubsquence(scanner.next(), scanner.next()));
    }
    public static int longestCommonSubsquence(String A, String B) {
        Integer[][] integers = new Integer[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++) {
            integers[0][i] = 0;
        }
        for (int i = 0; i <= B.length(); i++) {
            integers[i][0] = 0;
        }
        for (int i = 1; i <= B.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                if (B.charAt(i - 1) == A.charAt(j - 1)) {
                    integers[i][j] = integers[i-1][j-1] + 1;
                } else {
                    integers[i][j] = Math.max(integers[i-1][j], integers[i][j-1]);
                }
            }
        }
        return integers[B.length()][A.length()];
    }
}
