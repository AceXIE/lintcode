/**
 * Created by Administrator on 2016/4/15.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trapRainWater(h));
    }
    public static int trapRainWater(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int left = 0, right = heights.length - 1;
        int secH = 0, ans = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                secH = Math.max(secH, heights[left]);
                ans += secH - heights[left];
                left++;
            } else {
                secH = Math.max(secH, heights[right]);
                ans += secH - heights[right];
                right--;
            }
        }
        return ans;
    }
}
