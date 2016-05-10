/**
 * Created by Administrator on 2016/5/10.
 */
public class FindtheMissingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1,3};
        System.out.print(findMissing(nums));
    }
    public static int findMissing(int[] nums) {
        int N = nums.length;
        int ans = 0;
        int sum = ((N + 1) * N) /2;
        for (int t : nums) {
            sum = sum - t;
        }
        return sum;
    }
}
