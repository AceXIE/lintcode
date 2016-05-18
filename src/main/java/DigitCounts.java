/**
 * Created by Administrator on 2016/5/18.
 */
public class DigitCounts {
    public static void main(String[] args) {
        int n =12, k = 1;
        System.out.print(digitCounts(k,n));
    }
    public static int digitCounts(int k, int n) {
        int count = 0;
        char ck = (char) (k + '0');
        for (int i = 0; i <= n; i++) {
            String string = Integer.toString(i);
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == ck) {
                    count++;
                }
            }
        }
        return count;
    }
}
