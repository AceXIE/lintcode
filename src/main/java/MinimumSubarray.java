import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by xk on 2016/3/31.
 * 动态规划问题
 */
public class MinimumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        ArrayList<Integer> nums = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] numbers = string.split(" ");
//        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            nums.add(Integer.parseInt(numbers[i]));
        }
        System.out.print(minSubArray(nums));
    }
    public static int minSubArray(ArrayList<Integer> nums) {
        Integer local = new Integer(nums.get(0));
        Integer global = new Integer(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            local = Math.min(local + nums.get(i), nums.get(i));
            global = Math.min(global, local);
        }
        return global;
    }
}
