/**
 * Created by Administrator on 2016/6/21.
 */
public class PermutationSequence {
    public static void main(String[] args) {
        int n = 3, k =4;
        System.out.print(getPermutation(n,k));
    }
    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        int factor = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            factor *= (i + 1);
        }
        k--;
        String res = "";
        for (int i = 0; i < n; i++) {
            factor /= (n - i);//一层一层剥离
            int select = k/factor;
            res += nums[select];
            for (int j = select; j < n -i - 1; j++) {
                nums[j] = nums[j+1];
            }
            k = k%factor;
        }
        return res;
    }
}
