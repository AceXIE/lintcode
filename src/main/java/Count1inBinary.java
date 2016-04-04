import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/4.
 * 这里注意，-1
 */
public class Count1inBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countOnes(scanner.nextInt()));
    }
    public static int countOnes(int num) {
        if (num == 0) return 0;
        int res = 0;
        while (num != 0) {//-1!!!!!
            num = num & (num - 1);
            res++;
        }
        return res;
    }

}
