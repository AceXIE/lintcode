import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Main_NetEasy912_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] iteam = new int[n];

        for (int i = 0; i < n; i++) {
            iteam[i] = in.nextInt();
        }
        if (isPe(iteam, iteam.length)) {
            System.out.println(0);
            return;
        }
        int[] ori = new int[n];
        ori = Arrays.copyOf(iteam, n);
        int len = iteam.length;
        int time = Integer.MAX_VALUE;
        time = Rev(iteam, len - 1, 0);
//        for (int i = len - 1; i >= 0; i--) {
//            iteam = Arrays.copyOf(ori, n);
//            time = Math.min(time, Rev(iteam, i, 0));
//        }
        System.out.println(time);
    }
    public static int Rev(int[] nums, int end, int time) {
        if (isPe(nums, end + 1)) {
            return 0;
        } else {
            nums[end - 1] = nums[end - 1] + nums[end];
            end = end - 1;
            int itm = Rev(nums, end, time + 1);
            itm++;
            return itm;
        }
    }
    public static boolean isPe(int[] nums, int len) {
//        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            if (nums[i] != nums[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
