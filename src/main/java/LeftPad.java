/**
 * Created by Administrator on 2016/5/2.
 */
public class LeftPad {
    public static void main(String[] args) {
        System.out.println(leftPad("foo", 5));
        System.out.println(leftPad("foobar", 6));
        System.out.println(leftPad("1", 2, '0'));

    }
    public static String leftPad(String originalStr, int size) {
        if (originalStr == null) return null;
        if (originalStr.length() >= size) return originalStr;
        int bL = size - originalStr.length();
        for (int i = 0; i < bL; i++) {
            originalStr = ' ' + originalStr;
        }
        return originalStr;
    }
    public static String leftPad(String originalStr, int size, char padChar) {
        if (originalStr == null) return null;
        if (originalStr.length() >= size) return originalStr;
        int bL = size - originalStr.length();
        for (int i = 0; i < bL; i++) {
            originalStr = padChar + originalStr;
        }
        return originalStr;
    }
}
