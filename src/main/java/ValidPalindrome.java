/**
 * Created by Administrator on 2016/7/13.
 */
public class ValidPalindrome {
    public static void main(String[]  args) {
        String s = "race a car";//"A man, a plan, a canal: Panama";
        System.out.print(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            char bc = s.charAt(begin);
            char ec = s.charAt(end);
            if (!Character.isLetter(bc) && !Character.isDigit(bc)) {
                begin++;
                continue;
            }
            if (!Character.isLetter(ec) && !Character.isDigit(ec)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(bc) == Character.toLowerCase(ec)) {
                begin++;end--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
