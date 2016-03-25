import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/25.
 */
public class UglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isUgly(scanner.nextInt()));
    }
    public static boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        while (num%2 == 0) {
            num/=2;
            if (num == 1) return true;
        }
        while (num%3 == 0) {
            num/=3;
            if (num == 1) return true;
        }
        while (num%5 == 0) {
            num /=5;
            if (num == 1) return true;
        }
        return false;
    }
}
