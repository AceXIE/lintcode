import java.util.Stack;
import java.util.Vector;

/**
 * Created by Administrator on 2016/7/12.
 */
public class ReverseWordsinaString {
    public static void main(String[] args) {
        String s = "    the sky is blue";
        System.out.print(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String res = new String();
        s = s.trim();
        String[] strings1 = s.split(" ");
        for (int i = strings1.length - 1; i >= 0; i--) {
            if (strings1[i] == " ") continue;
            res = res + strings1[i];
            if (i!=0) {
                res += " ";
            }
        }
        return res;
    }
}
