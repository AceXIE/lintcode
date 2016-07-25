import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/25.
 */
public class DeleteDigits {
    public static void main(String[] args) {
        String A = "178542";
        System.out.print(DeleteDigits(A,4));
    }
    public static String DeleteDigits(String A, int k) {
        if (A == null) return null;
        if (A.length() == 0) return null;
        if (k == 0) return A;

        StringBuffer stringbuffer = new StringBuffer(A);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < stringbuffer.length(); j++) {
                if (j == stringbuffer.length() - 1 || stringbuffer.charAt(j) > stringbuffer.charAt(j + 1)) {
                    stringbuffer.deleteCharAt(j);
                    break;
                }
            }
        }
        int i = 0;
        for (; i < stringbuffer.length(); i++) {
            if (stringbuffer.charAt(i) != '0') {
                break;
            }
        }
        return stringbuffer.substring(i, stringbuffer.length());
    }
}
