/**
 * Created by Administrator on 2016/8/23.
 */
public class UpdateBits {
    public static void main(String[] args) {
        System.out.print(updateBits(0x400, 0x15, 2, 6));
    }
    public static int updateBits(int n, int m, int i, int j) {
        //从i到j变为0， 其余变为1
        int mask;
        if (j < 31) {
            mask = ~((1<<(j + 1)) - (1<<i));
        } else {
            mask = (1 << i) - 1;
        }

        return (m<<i) + (n&mask);
    }
}
