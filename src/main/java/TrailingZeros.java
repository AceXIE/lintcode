/**
 * Created by Administrator on 2016/5/10.
 */
public class TrailingZeros {
    public static void main(String[] args) {
        long n = 11;
        System.out.print(trailingZeros(n));
    }

    /***
     * 相当于几个5
     * @param n
     * @return
     */
    public static long trailingZeros(long n) {
        long res = 0;
        while (n != 0) {
            res += n/5;
            n = n/5;
        }
        return res;
    }
}
