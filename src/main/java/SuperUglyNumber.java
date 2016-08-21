import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/21.
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        System.out.print(nthSuperUglyNumber(6, primes));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] idx = new int[primes.length];
        Arrays.fill(dp, 1);
        Arrays.fill(idx, 0);
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[idx[j]]*primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[idx[j]] * primes[j]) {
                    idx[j]++;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
