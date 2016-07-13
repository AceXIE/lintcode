import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/13.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(numbers);
        for (ArrayList<Integer> integers : arrayLists) {
            System.out.print(integers);
        }
    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        if (numbers == null) return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int len = numbers.length;
        Arrays.sort(numbers);
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = numbers.length - 1;
            int target = -1 * (numbers[i]);
            while (left < right) {
                int t = numbers[left] + numbers[right];
                if (t < target) {
                    left++;
                } else if (t > target) {
                    right--;
                } else {
                    ArrayList<Integer> integer = new ArrayList<Integer>();
                    integer.add(numbers[i]);
                    integer.add(numbers[left]);
                    integer.add(numbers[right]);
                    if (!res.contains(integer)) {
                        res.add(integer);
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
