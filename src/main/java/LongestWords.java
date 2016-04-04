import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/4.
 */
public class LongestWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        System.out.println(longestWords(strings));
    }
    public static ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> res = new ArrayList<String>();
        if (dictionary == null) return res;
        Arrays.sort(dictionary, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        int max = dictionary[0].length();
        res.add(dictionary[0]);
        for (int i = 1; i < dictionary.length; i++) {
            int curlen = dictionary[i].length();
            if (curlen == max) {
                res.add(dictionary[i]);
            } else {
                break;
            }
        }
        return res;
    }
}
