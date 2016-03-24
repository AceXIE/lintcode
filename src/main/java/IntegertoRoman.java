import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/18.
 */
public class IntegertoRoman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(intToRoman(scanner.nextInt()));
    }

    public static String intToRoman(int n) {
        String res = new String();
        String[][] strings = new String[][]{
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","","MM",""}
        };
        int row=0;
        while (n > 0) {
            int col = n%10;
            res = strings[row][col] + res;
            n/=10;
            row++;
        }

        return res;
    }

}
