/**
 * Created by Administrator on 2016/7/23.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,3,2};
        System.out.print(maxArea(heights));
    }
    //比如，左边小于右边的，舍弃了右边的右边数据，这是必须的，因为组成的，不可能更大
    //
    public static int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) return 0;
        int left = 0, right = heights.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
