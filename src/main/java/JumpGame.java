import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/1.
 */
public class JumpGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = new String();
        string = scanner.nextLine();
        String[] strings = string.split(" ");
        int[] A = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            A[i] = Integer.parseInt(strings[i]);
        }
        System.out.print(canJump(A));
    }

    /***
     * 贪心算法，记录当前位置所能达到的最远距离
     * @param A
     * @return
     */
    public static boolean canJump(int[] A) {
        if(A.length == 0 || A.length == 1) return true;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + A[i]);
            }
        }
        return max >= A.length - 1;
    }
}
