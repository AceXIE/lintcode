import java.util.*;

/**
 * Created by Administrator on 2016/7/15.
 */
public class fourSum {
    public static void main(String[] args) {
        int[] numbers = {1,0,-1,-1,-1,-1,0,1,1,1,2};
        ArrayList<ArrayList<Integer>> res = fourSum(numbers, 2);
        for (ArrayList<Integer>it : res) {
            System.out.print(it);
        }
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> tres = new ArrayList<ArrayList<Integer>>();
        if (numbers.length < 4) return res;
        Arrays.sort(numbers);
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int left = j + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> integer = new ArrayList<Integer>();
                        integer.add(numbers[i]);
                        integer.add(numbers[j]);
                        integer.add(numbers[left]);
                        integer.add(numbers[right]);
                        tres.add(integer);
                        left++;
                        right--;
                    }
                }

            }
        }
        Set<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();

        for (int i= 0; i < tres.size(); i++) {
            ArrayList<Integer> it = tres.get(i);
            if (!set.contains(it)) {
                set.add(it);
            }
        }
        for (ArrayList<Integer> integers : set) {
            res.add(integers);
        }
        return res;
    }
}
