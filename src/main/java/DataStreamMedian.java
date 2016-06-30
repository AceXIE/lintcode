import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2016/6/30.
 */
public class DataStreamMedian {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] res = medianII(nums);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }
    public static int[] medianII(int[] nums) {
        if (nums == null) return nums;
        int[] res = new int[nums.length];
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        res[0] = nums[0];
        maxQueue.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int maxp = maxQueue.peek();
            if (nums[i] <= maxp) {
                maxQueue.add(nums[i]);
            } else {
                minQueue.add(nums[i]);
            }
            //调整
            if (maxQueue.size() > minQueue.size() + 1) {
                minQueue.add(maxQueue.poll());
            } else if (maxQueue.size() < minQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
            res[i] = maxQueue.peek();
        }
        return res;
    }
}
