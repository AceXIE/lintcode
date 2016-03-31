import java.util.Scanner;

/**
 * Created by xk on 2016/3/31.
 */
public class SortLettersbyCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = new String();
        string = scanner.nextLine();
        char[] chars = new char[string.length()];
        for (int i = 0 ; i < string.length(); i++) {
            chars[i] = string.charAt(i);
        }
        sortLetters(chars);
        for (int i = 0; i < string.length(); i++) {
            System.out.print(chars[i]);
        }
    }
    public static void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!Character.isLowerCase(chars[i])) {//大写
                if (Character.isLowerCase(chars[j])) {
                    char tmp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = tmp;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
    }
}
