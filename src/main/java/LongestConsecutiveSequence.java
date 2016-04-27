import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/27.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
//        int[] num = {1,2,0,1};
        System.out.print(longestConsecutive(num));
    }
    public static int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) return 0;
        if (num.length == 1) return 1;
        Arrays.sort(num);
        int count = 1;
        int ans = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == num[i - 1] + 1) {
                count++;
                ans = Math.max(ans, count);
            } else if (num[i] == num[i - 1]) {

            } else {
                ans = Math.max(ans, count);
                count=1;
            }
        }
        return ans;
    }
}
