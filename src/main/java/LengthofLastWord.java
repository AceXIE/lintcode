

/**
 * Created by Administrator on 2016/4/14.
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        String s = "hello world ";
        System.out.println(lengthofLastWord(s));
    }
    public static int lengthofLastWord(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (i == s.length() - 1) {
                    return len;
                }
                len = 0;
            } else {
                len++;
            }
        }
        return len;
    }
}
