import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/20.
 */
public class SubarraySumClosest {
    public static void main(String[] args) {
        int[] nums = {-3, 1, 1, -3, 5};
        int[] a = subarraySumClosest(nums);
        System.out.print(a[0] + "," + a[1]);
    }
    public static int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums.length == 0) return res;
        Ele[] sums = new Ele[nums.length + 1];
        sums[0] = new Ele(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = new Ele(sum, i);
        }
        Arrays.sort(sums);
        int min = Math.abs(sums[0].sum - sums[1].sum);
        int start = Math.min(sums[0].index, sums[1].index) + 1;
        int end = Math.max(sums[0].index, sums[1].index);
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.abs(sums[i].sum - sums[i + 1].sum);
            if (diff < min) {
                min = diff;
                start = Math.min(sums[i].index, sums[i + 1].index) + 1;
                end = Math.max(sums[i].index, sums[i + 1].index);
            }
        }
        res[0] = start;
        res[1] = end;

        return res;
    }

}
class Ele implements Comparable<Ele> {

    int sum;
    int index;


    public Ele(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }

    @Override
    public int compareTo(Ele o) {
        return this.sum - o.sum;
    }
}