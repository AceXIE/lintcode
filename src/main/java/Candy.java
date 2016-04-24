/**
 * Created by Administrator on 2016/4/24.
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings = {4,2,3,4,1};
        System.out.print(candy(ratings));
    }
    public static int candy(int[] ratings) {
        int [] ans = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            ans[i] = 1;
        }
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                ans[i + 1] = ans[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && ans[i - 1] <= ans[i]) {
                ans[i - 1] = ans[i] + 1;
            }
        }
        int sum = 0;
        for (int t : ans) {
            sum += t;
        }
        return sum;
    }
}
