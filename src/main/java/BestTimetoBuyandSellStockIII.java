/**
 * Created by Administrator on 2016/6/20.
 */
public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int[] prices = {4,4,6,1,1,4,2,5};
        System.out.print(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {//分成两段
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;

        int[] left = new int[len];
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int[] right = new int[len];
        right[len - 1] = 0;
        int max = prices[len - 1];
        for (int i = len -2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = Math.max(sum, left[i] + right[i]);
        }
        return sum;
    }
}
