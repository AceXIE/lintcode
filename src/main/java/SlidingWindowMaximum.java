import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 7, 8};
        int k = 3;
        ArrayList<Integer> res = maxSlidingWindow(nums,k);
        System.out.print(res);
    }
    //时间复杂度O(N)，空间复杂度O(K)
    //使用linkedList，双向队列
    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<Integer>();
        LinkedList<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            //发现头部下标为窗口左边下标，扔掉
            if (!q.isEmpty() && q.peek() == i - k)
                q.poll();
            //把头部小于新数的全扔掉
            while (!q.isEmpty() && nums[q.getLast()] < nums[i])
                q.removeLast();
            q.add(i);
            if ((i + 1) >= k)
                res.add(nums[q.getFirst()]);
        }
        return res;
    }
}
