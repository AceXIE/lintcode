/**
 * Created by Administrator on 2016/5/7.
 */
public class FlipBits {
    public static void main(String[] args) {
        int n = 31, m = 14;
        System.out.print(bitSwapRequired(n,m));
    }
    public static int bitSwapRequired(int a, int b) {
        int r = a ^ b, res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = r&1;
            res += bit;
            r = r>>1;
        }
        return res;
    }
}
