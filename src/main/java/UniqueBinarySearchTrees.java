/**
 * Created by Administrator on 2016/4/21.
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        System.out.print(numTrees(n));
    }
    public static int numTrees(int n) {
        int[] ans = new int[n + 1];
        if (n == 0) return 1;
        if (n < 3 && n >= 1) {
            return n;
        }
        ans[0] = 1;//n==0的时候，存在的BST数目
        ans[1] = 1;//n==1
        ans[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] += ans[j - 1]*ans[i - j];
            }
        }
        return ans[n];
    }
}
