import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/15.
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.print("Input : " + string + "\n");
        int res = romanToInt.romanToInt(string);
        System.out.print("Output : " + res);
    }
}
