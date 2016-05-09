import java.util.Arrays;

/**
 * Created by Administrator on 2016/5/9.
 */
public class ScrambleString {
    public static void main(String[] args) {
//        String s1 = "rgtae", s2 = "great";
        String s1 = "a", s2 = "a";
//        System.out.print(s1.substring(1,3));
        System.out.print(isScramble(s1,s2));
    }
    public static boolean isScramble(String s1, String s2) {
        boolean res = false; int len1 = s1.length(), len2 = s2.length();
        if (s1.length() != s2.length()) {
            return false;
        }
        if (len1 == 1) return s1.equals(s2);
        for (int i = 0; i < len1; i++) {
            if (s2.indexOf(s1.charAt(i)) == -1) {
                return false;
            }
        }
        String s11,s12,s21,s22;
        for (int i = 1; i < len1 && !res; i++) {
            s11 = s1.substring(0, i);
            s12 = s1.substring(i, len1);
            s21 = s2.substring(0, i);
            s22 = s2.substring(i, len1);
            res = isScramble(s11, s21) && isScramble(s12, s22);
            if (!res) {
                s21 = s2.substring(0, len1 - i);
                s22 = s2.substring(len1 - i, len1);
                res = isScramble(s11, s22) && isScramble(s12, s21);
            }
        }
        return res;
    }
}
