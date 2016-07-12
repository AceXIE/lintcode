/**
 * Created by Administrator on 2016/7/12.
 */
public class RotateString {
    public static void main(String[] args) {
        char[] str = {'a','b','c','d','e','f','g'};
        rotateString(str, 2);
        System.out.print(str);
    }
    public static void rotateString(char[] str, int offset) {
        if (offset == 0) return;
        if (str == null || str.length == 0) return;
        int len = str.length;
        offset = offset%len;
        rotate(str, 0, len - offset - 1);
        rotate(str, len - offset, len - 1);
        rotate(str, 0 , len - 1);
    }
    public static void rotate(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;end--;
        }
    }
}
