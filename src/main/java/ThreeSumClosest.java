import java.util.Arrays;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] numbers = {-1,2,1,-4};
        int target = 1;
        System.out.print(threeSumClosest(numbers,target));
    }
    public static int threeSumClosest(int[] numbers,int target) {
        int len = numbers.length;
        int dis = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < len - 2; i++) {
            int target1 = target - numbers[i];
            int two = twoSumClosest(numbers, i + 1, target1);
            int tmpdis = Math.abs(two - target1);
            if (tmpdis < dis) {
                res = two + numbers[i];
                dis = tmpdis;
                if (res == target) return res;
            }
        }
        return res;
    }
    public static int twoSumClosest(int[] numbers,int start, int target) {
        int begin = start, end = numbers.length - 1;
        int res = 0, dis = Integer.MAX_VALUE;
        while (begin < end) {
            int t = numbers[begin] + numbers[end];
            if (t < target) {
                if (target - t < dis) {
                    dis = target -t;
                    res = t;
                }
                begin++;
            } else if (t > target) {
                if (t - target < dis) {
                    dis = t - target;
                    res = t;
                }
                end--;
            } else {
                return target;
            }
        }
        return res;
    }
}
